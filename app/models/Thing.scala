package models

import play.api.libs.json._

/**
  * Created by johnjastrow on 5/20/16.
  */
case class Thing(myThing: String)

object Thing {
  implicit val thingReads = Json.reads[Thing]
  implicit val thingWrites = Json.writes[Thing]
}
