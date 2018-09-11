package controllers

import javax.inject.Inject
import com.mohiva.play.silhouette.api.actions.SecuredRequest
import com.mohiva.play.silhouette.api.{LogoutEvent, Silhouette}
import org.webjars.play.WebJarsUtil
import play.api.i18n.{I18nSupport, Messages}
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents}
import utils.auth.DefaultEnv
import play.api.libs.json.Json.toJson

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import com.mohiva.play.silhouette.api._
import play.api.Logger
import play.api.libs.json.{JsResult, Json}
import javax.inject._
import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

import scala.collection.mutable.ArrayBuffer

/**
  * The basic application controller.
  *
  * @param components  The Play controller components.
  * @param silhouette  The Silhouette stack.
  * @param webJarsUtil The webjar util.
  * @param assets      The Play assets finder.
  */
class ApplicationController @Inject()(
                                       components: ControllerComponents,
                                       silhouette: Silhouette[DefaultEnv]
                                     )(
                                       implicit
                                       webJarsUtil: WebJarsUtil,
                                       assets: AssetsFinder,
                                       ec: ExecutionContext
                                     ) extends AbstractController(components) with I18nSupport {

  /**
    * Handles the index action.
    *
    * @return The result to display.
    */
  def index = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>

    Future.successful(Redirect("http://localhost:3000/"))
  }



  def getUser = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>

    val userID = request.identity.userID
    val fullName = request.identity.fullName
    val email = request.identity.email
    var token = request.authenticator.id

    Future.successful(Ok(Json.obj("userID" -> userID, "fullName"->fullName,"email"->email,"log"->true)))
  }





  /**
    * Handles the Sign Out action.
    *
    * @return The result to display.
    */
  def signOut = silhouette.SecuredAction.async { implicit request: SecuredRequest[DefaultEnv, AnyContent] =>
    val result = Redirect("http://localhost:3000/")
    silhouette.env.eventBus.publish(LogoutEvent(request.identity, request))
    silhouette.env.authenticatorService.discard(request.authenticator, result)
  }
}
