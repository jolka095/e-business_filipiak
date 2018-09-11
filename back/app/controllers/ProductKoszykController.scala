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

class ProductKoszykController @Inject()( productKoszykRepository: ProductKoszykRepository, koszykRepository: KoszykRepository,  productsRepo: ProductRepository,
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

  val productKoszykForm: Form[CreateProductKoszykForm] = Form {
    mapping(
      "koszyk" -> number,
      "product" -> number,
      "liczba" -> number
    )(CreateProductKoszykForm.apply)(CreateProductKoszykForm.unapply)
  }
  /*
  def index = Action.async { implicit request =>
    val products = productsRepo.list()
    val koszyks = koszykRepository.list()
    products.flatMap { pro =>
      koszyks.map { kos =>
        Ok(views.html.koszykProduct(productKoszykForm,pro,kos))
      }
    }
  }
   */
  def addProductKoszyk = Action.async { implicit request =>

    //var a:Seq[Product] = Seq[Product]()
    //var b:Seq[Koszyk] = Seq[Koszyk]()

    //print(a)
    //print(b)

    //val products = productsRepo.list().onComplete{
    //  case Success(pro) => a= pro
    //  case Failure(_) => print("fail")
    //}
    //val koszyks = koszykRepository.list().onComplete{
    //  case Success(kos) => b= kos
    //  case Failure(_) => print("fail")
   // }
    productKoszykForm.bindFromRequest.fold(

      // The error function. We return the index page with the error form, which will render the errors.
      // We also wrap the result in a successful future, since this action is synchronous, but we're required to return
      // a future because the person creation function returns a future.
      errorForm => {
        Future.successful(
          //Ok("views.html.koszykProduct(errorForm,a,b)")
          Ok(Json.obj("result" -> false)).withHeaders(headers._1,headers._2,headers._3)
        )
      },
      // There were no errors in the from, so create the person.
      productKoszyk => {
        productKoszykRepository.create(productKoszyk.koszyk, productKoszyk.product, productKoszyk.liczba).map { _ =>
          // If successful, we simply redirect to the index page.
          //Ok("success-> product.created")
          Ok(Json.obj("result" -> true)).withHeaders(headers._1,headers._2,headers._3)
        }
      }
    )


  }

  def getKoszykProducts = Action.async { implicit request =>
    productKoszykRepository.list().map { products =>
      Ok(Json.toJson(products))
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
case class CreateProductKoszykForm(koszyk: Int, product: Int, liczba: Int)
