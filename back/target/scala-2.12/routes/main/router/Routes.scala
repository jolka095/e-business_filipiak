// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jolan/Desktop/bi/conf/routes
// @DATE:Wed Sep 05 19:46:42 CEST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  ProductController_3: controllers.ProductController,
  // @LINE:11
  CategoryController_4: controllers.CategoryController,
  // @LINE:16
  OpinionController_2: controllers.OpinionController,
  // @LINE:21
  KoszykController_1: controllers.KoszykController,
  // @LINE:27
  ApplicationController_8: controllers.ApplicationController,
  // @LINE:32
  SocialAuthController_7: controllers.SocialAuthController,
  // @LINE:37
  SignInController_5: controllers.SignInController,
  // @LINE:40
  ActivateAccountController_0: controllers.ActivateAccountController,
  // @LINE:44
  Assets_6: controllers.Assets,
  // @LINE:45
  webjars_Routes_0: webjars.Routes,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    ProductController_3: controllers.ProductController,
    // @LINE:11
    CategoryController_4: controllers.CategoryController,
    // @LINE:16
    OpinionController_2: controllers.OpinionController,
    // @LINE:21
    KoszykController_1: controllers.KoszykController,
    // @LINE:27
    ApplicationController_8: controllers.ApplicationController,
    // @LINE:32
    SocialAuthController_7: controllers.SocialAuthController,
    // @LINE:37
    SignInController_5: controllers.SignInController,
    // @LINE:40
    ActivateAccountController_0: controllers.ActivateAccountController,
    // @LINE:44
    Assets_6: controllers.Assets,
    // @LINE:45
    webjars_Routes_0: webjars.Routes
  ) = this(errorHandler, ProductController_3, CategoryController_4, OpinionController_2, KoszykController_1, ApplicationController_8, SocialAuthController_7, SignInController_5, ActivateAccountController_0, Assets_6, webjars_Routes_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ProductController_3, CategoryController_4, OpinionController_2, KoszykController_1, ApplicationController_8, SocialAuthController_7, SignInController_5, ActivateAccountController_0, Assets_6, webjars_Routes_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addproduct""", """controllers.ProductController.addProduct"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.ProductController.getProducts"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addcategory""", """controllers.CategoryController.addCategory"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoryController.getCategory"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addopinion""", """controllers.OpinionController.addOpinion"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """opinions""", """controllers.OpinionController.getOpinion"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """opinion/""" + "$" + """id<[^/]+>""", """controllers.OpinionController.getOpinionid(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addproductkoszyk""", """controllers.KoszykController.addKoszyk"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """koszyki""", """controllers.KoszykController.getKoszyk"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """koszyk/""" + "$" + """id<[^/]+>""", """controllers.KoszykController.getKoszykElem(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteproduct/""" + "$" + """id<[^/]+>""", """controllers.KoszykController.deleteKoszykItem(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.ApplicationController.getUser"""),
    ("""GET""", this.prefix, """controllers.ApplicationController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signOut""", """controllers.ApplicationController.signOut"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """authenticate/""" + "$" + """provider<[^/]+>""", """controllers.SocialAuthController.authenticate(provider:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signIn""", """controllers.SignInController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signIn""", """controllers.SignInController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/email/""" + "$" + """email<[^/]+>""", """controllers.ActivateAccountController.send(email:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/activate/""" + "$" + """token<[^/]+>""", """controllers.ActivateAccountController.activate(token:java.util.UUID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    prefixed_webjars_Routes_0_20.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_ProductController_addProduct0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addproduct")))
  )
  private[this] lazy val controllers_ProductController_addProduct0_invoker = createInvoker(
    ProductController_3.addProduct,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "addProduct",
      Nil,
      "POST",
      this.prefix + """addproduct""",
      """ Home page
GET     /product                           controllers.ProductController.index""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ProductController_getProducts1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private[this] lazy val controllers_ProductController_getProducts1_invoker = createInvoker(
    ProductController_3.getProducts,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getProducts",
      Nil,
      "GET",
      this.prefix + """products""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_CategoryController_addCategory2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addcategory")))
  )
  private[this] lazy val controllers_CategoryController_addCategory2_invoker = createInvoker(
    CategoryController_4.addCategory,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "addCategory",
      Nil,
      "POST",
      this.prefix + """addcategory""",
      """ kategorie
GET     /category                   controllers.CategoryController.index""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_CategoryController_getCategory3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoryController_getCategory3_invoker = createInvoker(
    CategoryController_4.getCategory,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "getCategory",
      Nil,
      "GET",
      this.prefix + """categories""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_OpinionController_addOpinion4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addopinion")))
  )
  private[this] lazy val controllers_OpinionController_addOpinion4_invoker = createInvoker(
    OpinionController_2.addOpinion,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OpinionController",
      "addOpinion",
      Nil,
      "POST",
      this.prefix + """addopinion""",
      """ opinion
GET     /opinion                  controllers.OpinionController.index""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_OpinionController_getOpinion5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("opinions")))
  )
  private[this] lazy val controllers_OpinionController_getOpinion5_invoker = createInvoker(
    OpinionController_2.getOpinion,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OpinionController",
      "getOpinion",
      Nil,
      "GET",
      this.prefix + """opinions""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_OpinionController_getOpinionid6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("opinion/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OpinionController_getOpinionid6_invoker = createInvoker(
    OpinionController_2.getOpinionid(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OpinionController",
      "getOpinionid",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """opinion/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_KoszykController_addKoszyk7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addproductkoszyk")))
  )
  private[this] lazy val controllers_KoszykController_addKoszyk7_invoker = createInvoker(
    KoszykController_1.addKoszyk,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.KoszykController",
      "addKoszyk",
      Nil,
      "POST",
      this.prefix + """addproductkoszyk""",
      """ koszyk
GET     /koszyk                  controllers.KoszykController.index""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_KoszykController_getKoszyk8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("koszyki")))
  )
  private[this] lazy val controllers_KoszykController_getKoszyk8_invoker = createInvoker(
    KoszykController_1.getKoszyk,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.KoszykController",
      "getKoszyk",
      Nil,
      "GET",
      this.prefix + """koszyki""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_KoszykController_getKoszykElem9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("koszyk/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_KoszykController_getKoszykElem9_invoker = createInvoker(
    KoszykController_1.getKoszykElem(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.KoszykController",
      "getKoszykElem",
      Seq(classOf[String]),
      "GET",
      this.prefix + """koszyk/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_KoszykController_deleteKoszykItem10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteproduct/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_KoszykController_deleteKoszykItem10_invoker = createInvoker(
    KoszykController_1.deleteKoszykItem(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.KoszykController",
      "deleteKoszykItem",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """deleteproduct/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_ApplicationController_getUser11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_ApplicationController_getUser11_invoker = createInvoker(
    ApplicationController_8.getUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "getUser",
      Nil,
      "GET",
      this.prefix + """user""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_ApplicationController_index12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_ApplicationController_index12_invoker = createInvoker(
    ApplicationController_8.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_ApplicationController_signOut13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signOut")))
  )
  private[this] lazy val controllers_ApplicationController_signOut13_invoker = createInvoker(
    ApplicationController_8.signOut,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "signOut",
      Nil,
      "GET",
      this.prefix + """signOut""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_SocialAuthController_authenticate14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authenticate/"), DynamicPart("provider", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SocialAuthController_authenticate14_invoker = createInvoker(
    SocialAuthController_7.authenticate(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SocialAuthController",
      "authenticate",
      Seq(classOf[String]),
      "GET",
      this.prefix + """authenticate/""" + "$" + """provider<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_SignInController_view15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signIn")))
  )
  private[this] lazy val controllers_SignInController_view15_invoker = createInvoker(
    SignInController_5.view,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignInController",
      "view",
      Nil,
      "GET",
      this.prefix + """signIn""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_SignInController_submit16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signIn")))
  )
  private[this] lazy val controllers_SignInController_submit16_invoker = createInvoker(
    SignInController_5.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignInController",
      "submit",
      Nil,
      "POST",
      this.prefix + """signIn""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_ActivateAccountController_send17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/email/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ActivateAccountController_send17_invoker = createInvoker(
    ActivateAccountController_0.send(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ActivateAccountController",
      "send",
      Seq(classOf[String]),
      "GET",
      this.prefix + """account/email/""" + "$" + """email<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_ActivateAccountController_activate18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/activate/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ActivateAccountController_activate18_invoker = createInvoker(
    ActivateAccountController_0.activate(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ActivateAccountController",
      "activate",
      Seq(classOf[java.util.UUID]),
      "GET",
      this.prefix + """account/activate/""" + "$" + """token<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_Assets_versioned19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned19_invoker = createInvoker(
    Assets_6.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:45
  private[this] val prefixed_webjars_Routes_0_20 = Include(webjars_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "webjars"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_ProductController_addProduct0_route(params@_) =>
      call { 
        controllers_ProductController_addProduct0_invoker.call(ProductController_3.addProduct)
      }
  
    // @LINE:8
    case controllers_ProductController_getProducts1_route(params@_) =>
      call { 
        controllers_ProductController_getProducts1_invoker.call(ProductController_3.getProducts)
      }
  
    // @LINE:11
    case controllers_CategoryController_addCategory2_route(params@_) =>
      call { 
        controllers_CategoryController_addCategory2_invoker.call(CategoryController_4.addCategory)
      }
  
    // @LINE:12
    case controllers_CategoryController_getCategory3_route(params@_) =>
      call { 
        controllers_CategoryController_getCategory3_invoker.call(CategoryController_4.getCategory)
      }
  
    // @LINE:16
    case controllers_OpinionController_addOpinion4_route(params@_) =>
      call { 
        controllers_OpinionController_addOpinion4_invoker.call(OpinionController_2.addOpinion)
      }
  
    // @LINE:17
    case controllers_OpinionController_getOpinion5_route(params@_) =>
      call { 
        controllers_OpinionController_getOpinion5_invoker.call(OpinionController_2.getOpinion)
      }
  
    // @LINE:18
    case controllers_OpinionController_getOpinionid6_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_OpinionController_getOpinionid6_invoker.call(OpinionController_2.getOpinionid(id))
      }
  
    // @LINE:21
    case controllers_KoszykController_addKoszyk7_route(params@_) =>
      call { 
        controllers_KoszykController_addKoszyk7_invoker.call(KoszykController_1.addKoszyk)
      }
  
    // @LINE:22
    case controllers_KoszykController_getKoszyk8_route(params@_) =>
      call { 
        controllers_KoszykController_getKoszyk8_invoker.call(KoszykController_1.getKoszyk)
      }
  
    // @LINE:24
    case controllers_KoszykController_getKoszykElem9_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_KoszykController_getKoszykElem9_invoker.call(KoszykController_1.getKoszykElem(id))
      }
  
    // @LINE:25
    case controllers_KoszykController_deleteKoszykItem10_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_KoszykController_deleteKoszykItem10_invoker.call(KoszykController_1.deleteKoszykItem(id))
      }
  
    // @LINE:27
    case controllers_ApplicationController_getUser11_route(params@_) =>
      call { 
        controllers_ApplicationController_getUser11_invoker.call(ApplicationController_8.getUser)
      }
  
    // @LINE:30
    case controllers_ApplicationController_index12_route(params@_) =>
      call { 
        controllers_ApplicationController_index12_invoker.call(ApplicationController_8.index)
      }
  
    // @LINE:31
    case controllers_ApplicationController_signOut13_route(params@_) =>
      call { 
        controllers_ApplicationController_signOut13_invoker.call(ApplicationController_8.signOut)
      }
  
    // @LINE:32
    case controllers_SocialAuthController_authenticate14_route(params@_) =>
      call(params.fromPath[String]("provider", None)) { (provider) =>
        controllers_SocialAuthController_authenticate14_invoker.call(SocialAuthController_7.authenticate(provider))
      }
  
    // @LINE:37
    case controllers_SignInController_view15_route(params@_) =>
      call { 
        controllers_SignInController_view15_invoker.call(SignInController_5.view)
      }
  
    // @LINE:38
    case controllers_SignInController_submit16_route(params@_) =>
      call { 
        controllers_SignInController_submit16_invoker.call(SignInController_5.submit)
      }
  
    // @LINE:40
    case controllers_ActivateAccountController_send17_route(params@_) =>
      call(params.fromPath[String]("email", None)) { (email) =>
        controllers_ActivateAccountController_send17_invoker.call(ActivateAccountController_0.send(email))
      }
  
    // @LINE:41
    case controllers_ActivateAccountController_activate18_route(params@_) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_ActivateAccountController_activate18_invoker.call(ActivateAccountController_0.activate(token))
      }
  
    // @LINE:44
    case controllers_Assets_versioned19_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned19_invoker.call(Assets_6.versioned(file))
      }
  
    // @LINE:45
    case prefixed_webjars_Routes_0_20(handler) => handler
  }
}
