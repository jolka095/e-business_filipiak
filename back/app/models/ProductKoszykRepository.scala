package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

/**
 * A repository for people.
 *
 * @param dbConfigProvider The Play db config provider. Play will inject this for you.
 */
@Singleton
class ProductKoszykRepository @Inject()(dbConfigProvider: DatabaseConfigProvider, val koszykRepository: KoszykRepository, val productRepository: ProductRepository)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
    val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._

  /**
   * Here we define the table. It will have a name of people
   */
  import koszykRepository.KoszykTable
  import productRepository.ProductTable
  private val kos = TableQuery[KoszykTable]
  private val pro = TableQuery[ProductTable]

   class ProductKoszykTable(tag: Tag) extends Table[ProductKoszyk](tag, "koszykprod") {

    /** The ID column, which is the primary key, and auto incremented */
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    /** The name column */
    def koszyk = column[Int]("koszyk")
    def product = column[Long]("product")
    def liczba = column[Int]("liczba")

    def product_fk = foreignKey("pro_fk",product, pro)(_.id)
     def koszyk_fk = foreignKey("kos_fk",koszyk, kos)(_.id)
    /**
     * This is the tables default "projection".
     *
     * It defines how the columns are converted to and from the Person object.
     *
     * In this case, we are simply passing the id, name and page parameters to the Person case classes
     * apply and unapply methods.
     */
    def * = (id, koszyk, product, liczba) <> ((ProductKoszyk.apply _).tupled, ProductKoszyk.unapply)
    //def * = (id, name) <> ((Category.apply _).tupled, Category.unapply)
  }

  /**
   * The starting point for all queries on the people table.
   */
  private  val koszykProduct = TableQuery[ProductKoszykTable]
  /**
   * Create a person with the given name and age.
   *
   * This is an asynchronous operation, it will return a future of the created person, which can be used to obtain the
   * id for that person.
   */
  def create(koszyk: Int, product: Int,liczba:Int): Future[ProductKoszyk] = db.run {
    // We create a projection of just the name and age columns, since we're not inserting a value for the id column
    (koszykProduct.map(p => (p.koszyk, p.product,p.liczba))
      // Now define it to return the id, because we want to know what id was generated for the person
      returning koszykProduct.map(_.id)
      // And we define a transformation for the returned value, which combines our original parameters with the
      // returned id
      into {case ((koszyk, product,liczba),id) => ProductKoszyk(id,koszyk, product,liczba)}
    // And finally, insert the person into the database
    ) += (koszyk, product,liczba)
  }

  /**
   * List all the people in the database.
   */
  def list(): Future[Seq[ProductKoszyk]] = db.run {
    koszykProduct.result
  }
}
