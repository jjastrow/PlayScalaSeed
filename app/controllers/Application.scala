package controllers

import models._
import play.api.mvc._
import play.api.libs.json.{JsError, Json}

import scala.collection.mutable.ListBuffer

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def jsonThing(parm: String) = Action {

    val allThings = ListBuffer[Thing]()
    allThings += Thing(s"One ${parm} thing", 1, true)
    allThings += Thing(s"Leads to another: ${parm}", 2, false)
    allThings += Thing("and yet", 3, false)

    Ok( Json toJson allThings )
  }

  def showThings = Action {
    Ok( Json toJson Thing.list)
  }

  def saveThing = Action(BodyParsers.parse.json) { request =>
    val res = request.body.validate[Thing].map{
      case thing => {
        if (Thing.save(thing)) {
          Ok(Json.obj("status" -> "OK", "message" -> ("Your Thing '" + thing.myThing + "' successfully saved.")))
        } else {
          UnprocessableEntity(Json.obj("status" -> "Unprocessable", "message" -> s"Failed to save: ${thing.myThing}"))
        }
      }
        // TODO: fix error properly!!   (.fold instead of .map maybe)
//      case _ =>  BadRequest(Json.obj("status" ->"KO"))
      }
    res.get
    }

  def cards = Action {
    Ok(views.html.cards("Card Game #2"))
  }
}
