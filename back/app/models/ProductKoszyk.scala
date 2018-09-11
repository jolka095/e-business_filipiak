package models

import play.api.libs.json._

case class ProductKoszyk(id: Long, koszyk:Int, product: Long, liczba: Int)

object ProductKoszyk {
  implicit val productKoszyk = Json.format[ProductKoszyk]
}



