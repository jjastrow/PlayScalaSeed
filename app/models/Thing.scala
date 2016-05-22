package models

import play.api.libs.json._

/**
  * Created by johnjastrow on 5/20/16.
  */
case class Thing(myThing: String)

object Thing {
  implicit val personReads = Json.reads[Thing]
  implicit val personWrites = Json.writes[Thing]
}
