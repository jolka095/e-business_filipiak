
package controllers

import java.util

import javax.inject._
import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.{JsObject, JsString, Json, JsValue}
import play.api.mvc._
import scala.collection.mutable._
import scala.collection.mutable.{ArrayBuffer, ListBuffer,HashMap}
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}


class KoszykController @Inject()(koszykRepo: KoszykRepository,
                                 productsRepo: ProductRepository,
                                  cc: MessagesControllerComponents
                                 )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  /**
    * The mapping for the person form.
    */
  val headers = (
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Host, Connection, Accept, Authorization, Content-Type, X-Requested-With, User-Agent, Referer, Methods"
  )

  val koszykForm: Form[CreateKoszykForm] = Form {
    mapping(
      "user" -> nonEmptyText,
      "product" -> number,
      "productName" ->nonEmptyText,
      "quantity" -> number,
      "price" -> number
    )(CreateKoszykForm.apply)(CreateKoszykForm.unapply)
  }

  /**
    * The index action.

  def index = Action.async { implicit request =>
    products.map(prod => Ok(views.html.koszyk(koszykForm,prod)))

  }*/


  def addKoszyk = Action.async { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    //var a:Seq[User] = Seq[User]()
    //val products = productsRepo.list().onComplete{
     // case Success(prod) => a=prod
     // case Failure(_) => print("fail")
    //}

    koszykForm.bindFromRequest.fold(
      // The error function. We return the index page with the error form, which will render the errors.
      // We also wrap the result in a successful future, since this action is synchronous, but we're required to return
      // a future because the person creation function returns a future.
      errorForm => {
        Future.successful(
         // Ok(views.html.koszyk(errorForm,a))
          Ok(Json.obj("result" -> false)).withHeaders(headers._1,headers._2,headers._3)
        )
      },
      // There were no errors in the from, so create the person.
      koszyk => {
        koszykRepo.create(koszyk.user, koszyk.product,koszyk.productName, koszyk.quantity, koszyk.price).map { _ =>
          // If successful, we simply redirect to the index page.
          //Redirect(routes.KoszykController.index).flashing("success" -> "product.created")
          Ok(Json.obj("result" -> true)).withHeaders(headers._1,headers._2,headers._3)
        }
      }
    )
  }


  /**
    * A REST endpoint that gets all the people as JSON.
    */
  def getKoszyk = Action.async { implicit request =>

    koszykRepo.list().map { op =>

      Ok(Json.toJson(op))
    }
  }

  def getKoszykElem(id: String)= Action.async { implicit request =>
    var card = new ArrayBuffer[Koszyk]()

    koszykRepo.list().map { products =>
      products.foreach(producttt => {
        if (producttt.user == id) {
          card += producttt
        }
      })
      Ok(Json.toJson(card)).withHeaders(headers._1,headers._2,headers._3)
    }
  }

  def deleteKoszykItem(id: Int) = Action.async { implicit request =>

    koszykRepo.delete(id).map { _ =>
      // If successful, we simply redirect to the index page.
      Ok(Json.obj("res" -> true)).withHeaders(headers._1, headers._2, headers._3)
    }
  }

}

/**
  * The create person form.
  *
  * Generally for forms, you should define separate objects to your models, since forms very often need to present data
  * in a different way to your models.  In this case, it doesn't make sense to have an id parameter in the form, since
  * that is generated once it's created.
  */
case class CreateKoszykForm(user: String, product: Int, productName: String, quantity: Int, price: Int)

