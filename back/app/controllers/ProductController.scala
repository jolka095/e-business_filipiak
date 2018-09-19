package controllers

import javax.inject._
import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

import play.api.http.HeaderNames

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class ProductController @Inject()(productsRepo: ProductRepository, categoryRepo: CategoryRepository,
                                  cc: MessagesControllerComponents
                                 )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  val headers = (
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Allow-Headers" -> "Host, Connection, Accept, Authorization, Content-Type, X-Requested-With, User-Agent, Referer, Methods"
  )

  /**
    * The mapping for the person form.
    */
  val productForm: Form[CreateProductForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "keyword" -> nonEmptyText,
      "category" -> number,
      "price" -> number,
      "imageUrl" -> nonEmptyText,
      "description" -> nonEmptyText
    )(CreateProductForm.apply)(CreateProductForm.unapply)
  }

  /**
    * The index action.
    */
  /*
  def index = Action.async { implicit request =>
    val categories = categoryRepo.list()
    categories.map(cat => Ok(views.html.index(productForm,cat)))

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

  def addProduct = Action.async { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    //var a:Seq[Category] = Seq[Category]()
    //val categories = categoryRepo.list().onComplete{
    //case Success(cat) => a= cat
    //case Failure(_) => print("fail")
    //}

    productForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          //Ok(views.html.index(errorForm,a))
          Ok(Json.obj("result" -> false)).withHeaders(headers._1, headers._2, headers._3)
        )
      },
      product => {
        productsRepo.create(product.name, product.keyword, product.category, product.price, product.imageUrl, product.description).map { _ =>
          //Redirect(routes.ProductController.index).flashing("success" -> "product.created")
          Ok(Json.obj("result" -> true)).withHeaders(headers._1, headers._2, headers._3)
        }
      }
    )
  }


  /**
    * A REST endpoint that gets all the people as JSON.
    */
  def getProducts = Action.async { implicit request =>
    productsRepo.list().map { products =>
      Ok(Json.toJson(products)).withHeaders(headers._1, headers._2, headers._3)
    }
  }

  def getProduct(product_id: Int) = Action.async { implicit request =>
    productsRepo.getProduct(product_id).map { p =>
      Ok(Json.toJson(p)).withHeaders(headers._1, headers._2, headers._3)
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
case class CreateProductForm(name: String, keyword: String, category: Int, price: Int, imageUrl: String, description: String)
