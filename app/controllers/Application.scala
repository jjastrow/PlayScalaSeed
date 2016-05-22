package controllers

import models.Thing
import play.api.mvc._
import play.api.libs.json.Json

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def json(parm: String) = Action {

    val thing1 = Thing(s"One ${parm} thing")
    val thing2 = Thing(s"Leads to another: ${parm}")
    val allThings = List(thing1, thing2)

    Ok( Json toJson allThings )
  }

  def cards = Action {
    Ok(views.html.cards("Card Game #1"))
  }

}
