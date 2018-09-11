
package views.html

/*1.2*/import play.api.i18n.Messages
/*2.2*/import play.api.mvc.RequestHeader
/*3.2*/import play.twirl.api.Html
/*4.2*/import org.webjars.play.WebJarsUtil
/*5.2*/import controllers.AssetsFinder

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[String,Option[models.User],Html,RequestHeader,Messages,AssetsFinder,WebJarsUtil,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(title: String, user: Option[models.User] = None)(content: Html)(implicit request: RequestHeader, messages: Messages, assets: AssetsFinder, webJarsUtil: WebJarsUtil):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.167*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/assets/*15.65*/.path("images/favicon.png")),format.raw/*15.92*/("""">
        <title>"""),_display_(/*16.17*/title),format.raw/*16.22*/("""</title>
        <link href="//fonts.googleapis.com/css?family=Roboto|Montserrat:400,700|Open+Sans:400,300,600" rel="stylesheet">
        <link href="//cdnjs.cloudflare.com/ajax/libs/ionicons/1.5.2/css/ionicons.min.css" rel="stylesheet">
        """),_display_(/*19.10*/Html(webJarsUtil.css("bootstrap.min.css"))),format.raw/*19.52*/("""
        """),_display_(/*20.10*/Html(webJarsUtil.css("bootstrap-theme.min.css"))),format.raw/*20.58*/("""
        """),format.raw/*21.9*/("""<link rel="stylesheet" href=""""),_display_(/*21.39*/assets/*21.45*/.path("styles/main.css")),format.raw/*21.69*/("""">
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
    </head>
    <body>
        <header class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">"""),_display_(/*33.48*/messages("toggle.navigation")),format.raw/*33.77*/("""</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href=""""),_display_(/*38.52*/controllers/*38.63*/.routes.ApplicationController.index),format.raw/*38.98*/("""">Silhouette Seed Template</a>
                </div>
                <nav class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href=""""),_display_(/*42.39*/controllers/*42.50*/.routes.ApplicationController.index),format.raw/*42.85*/("""">"""),_display_(/*42.88*/messages("home")),format.raw/*42.104*/("""</a></li>
                        <li><a href="https://github.com/mohiva/play-silhouette-seed">GitHub</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                    """),_display_(/*46.22*/user/*46.26*/.map/*46.30*/ { u =>_display_(Seq[Any](format.raw/*46.37*/("""
                    """),format.raw/*47.21*/("""<li><a href=""""),_display_(/*47.35*/controllers/*47.46*/.routes.ApplicationController.index),format.raw/*47.81*/("""">"""),_display_(/*47.84*/u/*47.85*/.name),format.raw/*47.90*/("""</a></li>
                    <li><a href=""""),_display_(/*48.35*/controllers/*48.46*/.routes.ApplicationController.signOut),format.raw/*48.83*/("""">"""),_display_(/*48.86*/messages("sign.out")),format.raw/*48.106*/("""</a></li>
                    """)))}/*49.22*/.getOrElse/*49.32*/ {_display_(Seq[Any](format.raw/*49.34*/("""
                        """),format.raw/*50.25*/("""<li><a href=""""),_display_(/*50.39*/controllers/*50.50*/.routes.SignInController.view),format.raw/*50.79*/("""">"""),_display_(/*50.82*/messages("sign.in")),format.raw/*50.101*/("""</a></li>

                    """)))}),format.raw/*52.22*/("""
                    """),format.raw/*53.21*/("""</ul>
                </nav>
            </div>
        </header>
        <main class="container">
            <div class="starter-template row">
                """),_display_(/*59.18*/request/*59.25*/.flash.get("error").map/*59.48*/ { msg =>_display_(Seq[Any](format.raw/*59.57*/("""
                    """),format.raw/*60.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-danger">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*62.34*/messages("error")),format.raw/*62.51*/("""</strong> """),_display_(/*62.62*/msg),format.raw/*62.65*/("""
                    """),format.raw/*63.21*/("""</div>
                """)))}),format.raw/*64.18*/("""
                """),_display_(/*65.18*/request/*65.25*/.flash.get("info").map/*65.47*/ { msg =>_display_(Seq[Any](format.raw/*65.56*/("""
                    """),format.raw/*66.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*68.34*/messages("info")),format.raw/*68.50*/("""</strong> """),_display_(/*68.61*/msg),format.raw/*68.64*/("""
                    """),format.raw/*69.21*/("""</div>
                """)))}),format.raw/*70.18*/("""
                """),_display_(/*71.18*/request/*71.25*/.flash.get("success").map/*71.50*/ { msg =>_display_(Seq[Any](format.raw/*71.59*/("""
                    """),format.raw/*72.21*/("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        <strong>"""),_display_(/*74.34*/messages("success")),format.raw/*74.53*/("""</strong> """),_display_(/*74.64*/msg),format.raw/*74.67*/("""
                    """),format.raw/*75.21*/("""</div>
                """)))}),format.raw/*76.18*/("""
                """),_display_(/*77.18*/content),format.raw/*77.25*/("""
            """),format.raw/*78.13*/("""</div>
        </main>
        """),_display_(/*80.10*/Html(webJarsUtil.script("jquery.min.js"))),format.raw/*80.51*/("""
        """),_display_(/*81.10*/Html(webJarsUtil.script("bootstrap.min.js"))),format.raw/*81.54*/("""
        """),format.raw/*82.9*/("""<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
        <script src=""""),_display_(/*83.23*/assets/*83.29*/.path("javascripts/zxcvbnShim.js")),format.raw/*83.63*/(""""></script>
    </body>
</html>"""))
      }
    }
  }

  def render(title:String,user:Option[models.User],content:Html,request:RequestHeader,messages:Messages,assets:AssetsFinder,webJarsUtil:WebJarsUtil): play.twirl.api.HtmlFormat.Appendable = apply(title,user)(content)(request,messages,assets,webJarsUtil)

  def f:((String,Option[models.User]) => (Html) => (RequestHeader,Messages,AssetsFinder,WebJarsUtil) => play.twirl.api.HtmlFormat.Appendable) = (title,user) => (content) => (request,messages,assets,webJarsUtil) => apply(title,user)(content)(request,messages,assets,webJarsUtil)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Sep 05 19:46:43 CEST 2018
                  SOURCE: C:/Users/jolan/Desktop/bi/app/views/main.scala.html
                  HASH: ee86cf0f72f1eee0fe469c224d9a5dd70b2244c5
                  MATRIX: 28->1|65->33|106->69|140->98|183->136|591->172|852->337|882->341|1187->619|1202->625|1250->652|1297->672|1323->677|1600->927|1663->969|1701->980|1770->1028|1807->1038|1864->1068|1879->1074|1924->1098|2656->1803|2706->1832|2992->2091|3012->2102|3068->2137|3294->2336|3314->2347|3370->2382|3400->2385|3438->2401|3688->2624|3701->2628|3714->2632|3759->2639|3809->2661|3850->2675|3870->2686|3926->2721|3956->2724|3966->2725|3992->2730|4064->2775|4084->2786|4142->2823|4172->2826|4214->2846|4265->2878|4284->2888|4324->2890|4378->2916|4419->2930|4439->2941|4489->2970|4519->2973|4560->2992|4625->3026|4675->3048|4871->3217|4887->3224|4919->3247|4966->3256|5016->3278|5219->3454|5257->3471|5295->3482|5319->3485|5369->3507|5425->3532|5471->3551|5487->3558|5518->3580|5565->3589|5615->3611|5816->3785|5853->3801|5891->3812|5915->3815|5965->3837|6021->3862|6067->3881|6083->3888|6117->3913|6164->3922|6214->3944|6418->4121|6458->4140|6496->4151|6520->4154|6570->4176|6626->4201|6672->4220|6700->4227|6742->4241|6803->4275|6865->4316|6903->4327|6968->4371|7005->4381|7141->4490|7156->4496|7211->4530
                  LINES: 4->1|5->2|6->3|7->4|8->5|13->7|18->7|20->9|26->15|26->15|26->15|27->16|27->16|30->19|30->19|31->20|31->20|32->21|32->21|32->21|32->21|44->33|44->33|49->38|49->38|49->38|53->42|53->42|53->42|53->42|53->42|57->46|57->46|57->46|57->46|58->47|58->47|58->47|58->47|58->47|58->47|58->47|59->48|59->48|59->48|59->48|59->48|60->49|60->49|60->49|61->50|61->50|61->50|61->50|61->50|61->50|63->52|64->53|70->59|70->59|70->59|70->59|71->60|73->62|73->62|73->62|73->62|74->63|75->64|76->65|76->65|76->65|76->65|77->66|79->68|79->68|79->68|79->68|80->69|81->70|82->71|82->71|82->71|82->71|83->72|85->74|85->74|85->74|85->74|86->75|87->76|88->77|88->77|89->78|91->80|91->80|92->81|92->81|93->82|94->83|94->83|94->83
                  -- GENERATED --
              */
          