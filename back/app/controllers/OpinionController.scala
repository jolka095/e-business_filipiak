package controllers

import javax.inject._
import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import play.api.http.HeaderNames
import scala.collection.mutable.ArrayBuffer






class OpinionController @Inject()(opinionRepo: OpinionRepository, productsRepo: ProductRepository,
                                  cc: MessagesControllerComponents
                                 )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  /**
    * The mapping for the person form.
    */
  val opinionForm: Form[CreateOpinionForm] = Form {
    mapping(
      "opin" -> nonEmptyText,
      "product" -> number
    )(CreateOpinionForm.apply)(CreateOpinionForm.unapply)
  }

  val headers = (
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Host, Connection, Accept, Authorization, Content-Type, X-Requested-With, User-Agent, Referer, Methods"
  )

  /**
    * The index action.
    */
  /*
  def index = Action.async { implicit request =>
    val products = productsRepo.list()
    products.map(prod => Ok(views.html.opinion(opinionForm,prod)))

    /*
    .onComplete{
    case Success(categories) => Ok(views.html.index(productForm,categories))
    case Failure(t) => print("")
  }*/
  }
   */

  /**
    * The add person action.
    *
    * This is asynchronous, since we're invoking the asynchronous methods on PersonRepository.
    */
  /*
    def addProduct = Action.async { implicit request =>
      Ok(views.html.addproduct())
    }
  */

  def addOpinion = Action.async { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    //var a:Seq[Product] = Seq[Product]()
    //val products = productsRepo.list().onComplete{
    //  case Success(prod) => a=prod
    //  case Failure(_) => print("fail")
   // }

    opinionForm.bindFromRequest.fold(
      // The error function. We return the index page with the error form, which will render the errors.
      // We also wrap the result in a successful future, since this action is synchronous, but we're required to return
      // a future because the person creation function returns a future.
      errorForm => {
        Future.successful(
          //Ok(views.html.opinion(errorForm,a))
          Ok(Json.obj("result" -> false)).withHeaders(headers._1,headers._2,headers._3)
        )
      },
      // There were no errors in the from, so create the person.
      opinion => {
        opinionRepo.create(opinion.product,opinion.opin ).map { _ =>
          // If successful, we simply redirect to the index page.
          //Redirect(routes.OpinionController.index).flashing("success" -> "product.created")
          Ok(Json.obj("result" -> true)).withHeaders(headers._1,headers._2,headers._3)
        }
      }
    )
  }


  /**
    * A REST endpoint that gets all the people as JSON.
    */
  def getOpinion = Action.async { implicit request =>
    opinionRepo.list().map { op =>
      Ok(Json.toJson(op)).withHeaders(headers._1,headers._2,headers._3)
    }
  }

  def getOpinionid(id: Int) = Action.async { implicit request =>
    var opinionById = new ArrayBuffer[Opinion]()

    opinionRepo.list().map { products =>
      products.foreach(producttt => {
        if (producttt.product == id) {
          opinionById += producttt
        }
      })
      Ok(Json.toJson(opinionById)).withHeaders(headers._1,headers._2,headers._3)
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
case class CreateOpinionForm(opin: String,  product: Int)
