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
class ZamowienieRepository @Inject()(dbConfigProvider: DatabaseConfigProvider, val koszykRepository: KoszykRepository)(implicit ec: ExecutionContext) {
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
  private val kos = TableQuery[KoszykTable]
   class ZamowienieTable(tag: Tag) extends Table[Zamowienie](tag, "zamowienie") {

    /** The ID column, which is the primary key, and auto incremented */
    def id = column[Long]("Za_id", O.PrimaryKey, O.AutoInc)

    /** The name column */
    def koszyk = column[Int]("koszyk")

    /** The age column */
    def dataZam = column[String]("dataZam")
    def address = column[String]("address")
    def wartosc = column[Float]("wartosc")

    def koszyk_fk = foreignKey("kos_fk",koszyk, kos)(_.id)
    /**
     * This is the tables default "projection".
     *
     * It defines how the columns are converted to and from the Person object.
     *
     * In this case, we are simply passing the id, name and page parameters to the Person case classes
     * apply and unapply methods.
     */
    def * = (id, koszyk, dataZam, address, wartosc) <> ((Zamowienie.apply _).tupled, Zamowienie.unapply)
    //def * = (id, name) <> ((Category.apply _).tupled, Category.unapply)
  }

  /**
   * The starting point for all queries on the people table.
   */


  private val zamowienie = TableQuery[ZamowienieTable]




  /**
   * Create a person with the given name and age.
   *
   * This is an asynchronous operation, it will return a future of the created person, which can be used to obtain the
   * id for that person.
   */
  def create(koszyk: Int, dataZam: String,address:String, wartosc: Float): Future[Zamowienie] = db.run {
    // We create a projection of just the name and age columns, since we're not inserting a value for the id column
    (zamowienie.map(p => (p.koszyk, p.dataZam,p.address,p.wartosc))
      // Now define it to return the id, because we want to know what id was generated for the person
      returning zamowienie.map(_.id)
      // And we define a transformation for the returned value, which combines our original parameters with the
      // returned id
      into {case ((koszyk, dataZam,address,wartosc),id) => Zamowienie(id,koszyk, dataZam,address,wartosc)}
    // And finally, insert the person into the database
    ) += (koszyk, dataZam,address,wartosc)
  }

  /**
   * List all the people in the database.
   */
  def list(): Future[Seq[Zamowienie]] = db.run {
    zamowienie.result
  }
}
