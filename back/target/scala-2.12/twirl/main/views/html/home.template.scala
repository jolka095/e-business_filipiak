
package views.html

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.api.mvc.RequestHeader
/*3.2*/import org.webjars.play.WebJarsUtil
/*4.2*/import controllers.AssetsFinder

object home extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[models.User,RequestHeader,Messages,WebJarsUtil,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*6.2*/(user: models.User)(implicit request: RequestHeader, messages: Messages, webJarsUtil: WebJarsUtil, assets: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*6.122*/("""

"""),_display_(/*8.2*/main(messages("home.title"), Some(user))/*8.42*/ {_display_(Seq[Any](format.raw/*8.44*/("""
    """),format.raw/*9.5*/("""<div class="user col-md-6 col-md-offset-3">
        <div class="row">
            <hr class="col-md-12" />
            <h4 class="col-md-8">"""),_display_(/*12.35*/messages("welcome.signed.in")),format.raw/*12.64*/("""</h4>
            <hr class="col-md-12" />
        </div>
        <div class="row data">
            <div class="col-md-12">
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*18.50*/messages("first.name")),format.raw/*18.72*/(""":</strong></p><p class="col-md-6">"""),_display_(/*18.107*/user/*18.111*/.firstName.getOrElse("None")),format.raw/*18.139*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*21.50*/messages("last.name")),format.raw/*21.71*/(""":</strong></p><p class="col-md-6">"""),_display_(/*21.106*/user/*21.110*/.lastName.getOrElse("None")),format.raw/*21.137*/("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""),_display_(/*24.50*/messages("email")),format.raw/*24.67*/(""":</strong></p><p class="col-md-6">"""),_display_(/*24.102*/user/*24.106*/.email.getOrElse("None")),format.raw/*24.130*/("""</p>
                </div>
            </div>
        </div>
    </div>
""")))}))
      }
    }
  }

  def render(user:models.User,request:RequestHeader,messages:Messages,webJarsUtil:WebJarsUtil,assets:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(user)(request,messages,webJarsUtil,assets)

  def f:((models.User) => (RequestHeader,Messages,WebJarsUtil,AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (user) => (request,messages,webJarsUtil,assets) => apply(user)(request,messages,webJarsUtil,assets)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Sep 05 19:46:43 CEST 2018
                  SOURCE: C:/Users/jolan/Desktop/bi/app/views/home.scala.html
                  HASH: b274b4ef148d13edafcbaa98fa3299d81d68043c
                  MATRIX: 28->1|65->33|106->69|149->107|537->143|753->263|783->268|831->308|870->310|902->316|1073->460|1123->489|1364->703|1407->725|1470->760|1484->764|1534->792|1675->906|1717->927|1780->962|1794->966|1843->993|1984->1107|2022->1124|2085->1159|2099->1163|2145->1187
                  LINES: 4->1|5->2|6->3|7->4|12->6|17->6|19->8|19->8|19->8|20->9|23->12|23->12|29->18|29->18|29->18|29->18|29->18|32->21|32->21|32->21|32->21|32->21|35->24|35->24|35->24|35->24|35->24
                  -- GENERATED --
              */
          