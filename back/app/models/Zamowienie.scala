package models


import play.api.libs.json._

case class Zamowienie(id: Long, koszyk: Int, dataZam: String, address: String, wartosc: Float)

object Zamowienie {
  implicit val zamowienieFormat = Json.format[Zamowienie]
}


