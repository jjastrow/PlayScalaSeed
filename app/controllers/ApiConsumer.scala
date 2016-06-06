package controllers

import javax.inject.Inject

import play.api.libs.ws._
import play.api.mvc._
import play.api.Play.current

import scala.concurrent.{Await, TimeoutException}
import scala.concurrent.duration._

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by johnjastrow on 5/25/16.
  */
class ApiConsumer @Inject()(ws: WSClient) extends Controller {

  def getWeather = Action {
    val promiseOfString = WS.url("http://weather.yahooapis.com/forecastrss?p=80020&u=f").get().map {
      response => response.body
    }
    try {
      val result = Await.result(promiseOfString, 5.seconds)    // Blocking with `Await`
      Ok(result)
    } catch {
      case e: TimeoutException => InternalServerError("Request timed out.")
    }
  }

  def callSinatra = Action {
    val sinatraService = "http://localhost:4567/"
    val promiseOfString = WS.url(sinatraService).get().map {
      response => response.body
    }
    try {
      val result = Await.result(promiseOfString, 5.seconds)    // Blocking with `Await`
      Ok(result)
    } catch {
      case e: TimeoutException => InternalServerError(s"Some error calling: ${sinatraService}")
    }
  }

  def callSinatraText(text: String) = Action {

    val sinatraService = s"http://localhost:4567/text/${text}"
    val promiseOfString = WS.url(sinatraService).get().map {
      response => response.body
    }
    try {
      val result = Await.result(promiseOfString, 5.seconds)    // Blocking with `Await`
      Ok(result)
    } catch {
      case e: TimeoutException => InternalServerError(s"Some error calling: ${sinatraService}")
    }
  }
}
