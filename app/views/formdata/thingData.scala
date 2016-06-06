package views.formdata

import models.Thing
import play.api.data.Form
import play.api.data.Forms._

/**
  * Created by johnjastrow on 5/23/16.
  */
class ThingData {

  val thingForm = Form(
    mapping(
      "myThing" -> text,
      "count" -> number(min = 0, max = 100),
      "active" -> boolean
    )(Thing.apply)(Thing.unapply)
  )
}
