package models

import play.api.libs.json.Json
import play.api.data._
import play.api.data.Forms._

/**
  * Created by johnjastrow on 5/20/16.
  */
case class Thing(myThing: String, count: Int, active: Boolean)

object Thing {
  implicit val thingReads = Json.reads[Thing]
  implicit val thingWrites = Json.writes[Thing]

  var list: List[Thing] = {
    // default data to start
    List(
      Thing("strange thing", 1, false),
      Thing("odd thing", 26, true)
      )
  }

  def save(thing: Thing): Boolean = {
    val listCount = list.size
    list = list ::: List(thing)
    list.size > listCount
  }

  def remove(thing: Thing) = {
    list = list.filter( t => t != thing)
  }

}
