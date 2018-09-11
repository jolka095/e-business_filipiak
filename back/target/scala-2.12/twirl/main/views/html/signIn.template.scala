
package views.html

/*2.2*/import play.api.data.Form
/*3.2*/import play.api.i18n.Messages
/*4.2*/import play.api.mvc.RequestHeader
/*5.2*/import org.webjars.play.WebJarsUtil
/*6.2*/import controllers.AssetsFinder
/*7.2*/import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
/*8.2*/import forms.SignInForm.Data
/*9.2*/import b3.inline.fieldConstructor

object signIn extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[Form[Data],SocialProviderRegistry,RequestHeader,Messages,WebJarsUtil,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*11.2*/(signInForm: Form[Data], socialProviders: SocialProviderRegistry)(implicit request: RequestHeader, messages: Messages, webJarsUtil: WebJarsUtil, assets: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*11.168*/("""

"""),_display_(/*13.2*/main(messages("Zaloguj się"))/*13.31*/ {_display_(Seq[Any](format.raw/*13.33*/("""
    """),format.raw/*14.5*/("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""),_display_(/*15.18*/messages("sign.in.credentials")),format.raw/*15.49*/("""</legend>

        """),_display_(/*17.10*/if(socialProviders.providers.nonEmpty)/*17.48*/ {_display_(Seq[Any](format.raw/*17.50*/("""
            """),format.raw/*18.13*/("""<div class="social-providers">
                <div>

                    <a href="/authenticate/google" class="provider google" title="google"><img src="/assets/images/providers/google.png" width="64px" height="64px" alt="google"></a>

                </div>
            </div>
        """)))}),format.raw/*25.10*/("""

    """),format.raw/*27.5*/("""</fieldset>
""")))}))
      }
    }
  }

  def render(signInForm:Form[Data],socialProviders:SocialProviderRegistry,request:RequestHeader,messages:Messages,webJarsUtil:WebJarsUtil,assets:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(signInForm,socialProviders)(request,messages,webJarsUtil,assets)

  def f:((Form[Data],SocialProviderRegistry) => (RequestHeader,Messages,WebJarsUtil,AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (signInForm,socialProviders) => (request,messages,webJarsUtil,assets) => apply(signInForm,socialProviders)(request,messages,webJarsUtil,assets)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Sep 05 19:46:43 CEST 2018
                  SOURCE: C:/Users/jolan/Desktop/bi/app/views/signIn.scala.html
                  HASH: 487e2e391dd6906016be2f53c71c11b847c30eae
                  MATRIX: 28->3|61->31|98->63|139->99|182->137|221->171|300->245|336->276|751->314|1014->480|1045->485|1083->514|1123->516|1156->522|1245->584|1297->615|1346->637|1393->675|1433->677|1475->691|1801->986|1836->994
                  LINES: 4->2|5->3|6->4|7->5|8->6|9->7|10->8|11->9|16->11|21->11|23->13|23->13|23->13|24->14|25->15|25->15|27->17|27->17|27->17|28->18|35->25|37->27
                  -- GENERATED --
              */
          