package models

import play.api.libs.json._

case class Opinion(id: Long, product: Long, opin: String)

object Opinion {
  implicit val opinionFormat = Json.format[Opinion]
}




