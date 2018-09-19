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

class ZamowienieController @Inject()(
                                      zamowienieRepository: ZamowienieRepository,
                                      koszykRepository: KoszykRepository,
                                      cc: MessagesControllerComponents
                                    )
                                    (implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  // mapping
  val zamowienieForm: Form[CreateZamowienieForm] = Form {
    mapping(
      "koszyk" -> number,
      "dataZam" -> nonEmptyText,
      "address" -> nonEmptyText,
      "wartosc" -> number
    )(CreateZamowienieForm.apply)(CreateZamowienieForm.unapply)
  }

  // asynchroniczna akcja - dodanie zamowienia
  def addZamowienie = Action.async { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    var a: Seq[Koszyk] = Seq[Koszyk]()
    val koszyks = koszykRepository.list().onComplete {
      case Success(kos) => a = kos
      case Failure(_) => print("fail")
    }

    zamowienieForm.bindFromRequest.fold(

      errorForm => {
        Future.successful(
          Ok("views.html.zamowienie(errorForm,a)")
        )
      },
      // if there were no errors in the from...
      zamowienie => {
        zamowienieRepository.create(zamowienie.koszyk, zamowienie.dataZam, zamowienie.address, zamowienie.wartosc).map { _ =>
          Ok("successproduct.created")
        }
      }
    )
  }


  // A REST endpoint that gets order as JSON.
  def getZamowienie = Action.async { implicit request =>
    zamowienieRepository.list().map { zam =>
      Ok(Json.toJson(zam))
    }
  }
}

// The create order form.
case class CreateZamowienieForm(koszyk: Int, dataZam: String, address: String, wartosc: Int)
