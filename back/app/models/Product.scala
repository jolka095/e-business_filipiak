package models

import play.api.libs.json._

case class Product(id: Long, name: String, keyword: String, category: Int, price: Int, imageUrl:  String, description: String)

object Product {
  implicit val productFormat = Json.format[Product]
}
