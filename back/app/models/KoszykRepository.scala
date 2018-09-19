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
class KoszykRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._

  /**
    * Here we define the table. It will have a name of people
    */
  //import userRepository.UserTable
  //private val prod = TableQuery[UserTable]

  class KoszykTable(tag: Tag) extends Table[Koszyk](tag, "koszyk") {

    /** The ID column, which is the primary key, and auto incremented */
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

    /** The name column */
    def user = column[String]("user")

    def product = column[Int]("product")

    def productName = column[String]("productName")

    def quantity = column[Int]("quantity")

    def price = column[Int]("price")

    //def user_fk = 1//foreignKey("user_fk",user,prod)(_.id)
    /**
      * This is the tables default "projection".
      *
      * It defines how the columns are converted to and from the Person object.
      *
      * In this case, we are simply passing the id, name and page parameters to the Person case classes
      * apply and unapply methods.
      */
    def * = (id, user, product, productName, quantity, price) <> ((Koszyk.apply _).tupled, Koszyk.unapply)

    //def * = (id, name) <> ((Category.apply _).tupled, Category.unapply)
  }

  /**
    * The starting point for all queries on the people table.
    */


  private val koaszyk = TableQuery[KoszykTable]


  /**
    * Create a person with the given name and age.
    *
    * This is an asynchronous operation, it will return a future of the created person, which can be used to obtain the
    * id for that person.
    */

  def create(user1: String, product1: Int, productName: String, quantity: Int, price: Int): Future[Boolean] = {
    println(user1);
    db.run(koaszyk.filter(_.user === user1).exists.result).flatMap { exists =>
      if (exists) {

        db.run(koaszyk.filter(_.product === product1).exists.result).flatMap { exists1 =>
          if (exists1) {

            val id = product1
            val us = user1

            val action = sql"update koszyk set quantity = (quantity+1) where product == $id and user == $us".as[(String)]

            db.run(action).map(res => true)
          }
          else {
            //println(item.product_id + " not exists!!")
            db.run {

              (koaszyk.map(p => (p.user, p.product, p.productName, p.quantity, p.price))

                returning koaszyk.map(_.id)

                into { case ((user1, product1, productName, quantity, price), id) => Koszyk(id, user1, product1, productName, quantity, price) }

                ) += (user1, product1, productName, quantity, price)
            }.map(res => true)
          }
        }
      }
      else {
        //println(item.product_id + " not exists!!")
        db.run {

          (koaszyk.map(p => (p.user, p.product, p.productName, p.quantity, p.price))

            returning koaszyk.map(_.id)

            into { case ((user1, product1, productName, quantity, price), id) => Koszyk(id, user1, product1, productName, quantity, price) }

            ) += (user1, product1, productName, quantity, price)
        }.map(res => true)
      }
    }
  }

  /**
    * List all the people in the database.
    */
  def list(): Future[Seq[Koszyk]] = db.run {
    koaszyk.result
  }

  def delete(product: Int): Future[Int] = {
    db.run(koaszyk.filter(_.id === product).delete)
  }
}
