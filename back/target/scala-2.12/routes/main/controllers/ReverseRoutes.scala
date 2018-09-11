// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jolan/Desktop/bi/conf/routes
// @DATE:Wed Sep 05 19:46:42 CEST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

// @LINE:7
package controllers {

  // @LINE:16
  class ReverseOpinionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getOpinionid(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "opinion/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:17
    def getOpinion(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "opinions")
    }
  
    // @LINE:16
    def addOpinion(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addopinion")
    }
  
  }

  // @LINE:44
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:37
  class ReverseSignInController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def view(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signIn")
    }
  
    // @LINE:38
    def submit(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "signIn")
    }
  
  }

  // @LINE:32
  class ReverseSocialAuthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def authenticate(provider:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "authenticate/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("provider", provider)))
    }
  
  }

  // @LINE:27
  class ReverseApplicationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def getUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:31
    def signOut(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signOut")
    }
  
    // @LINE:30
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:40
  class ReverseActivateAccountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def activate(token:java.util.UUID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "account/activate/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("token", token)))
    }
  
    // @LINE:40
    def send(email:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "account/email/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("email", email)))
    }
  
  }

  // @LINE:11
  class ReverseCategoryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def addCategory(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addcategory")
    }
  
    // @LINE:12
    def getCategory(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories")
    }
  
  }

  // @LINE:21
  class ReverseKoszykController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def addKoszyk(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addproductkoszyk")
    }
  
    // @LINE:24
    def getKoszykElem(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "koszyk/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:22
    def getKoszyk(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "koszyki")
    }
  
    // @LINE:25
    def deleteKoszykItem(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deleteproduct/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
  }

  // @LINE:7
  class ReverseProductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def addProduct(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addproduct")
    }
  
    // @LINE:8
    def getProducts(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products")
    }
  
  }


}
