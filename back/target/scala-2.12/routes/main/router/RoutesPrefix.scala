// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jolan/Desktop/bi/conf/routes
// @DATE:Wed Sep 05 19:46:42 CEST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
