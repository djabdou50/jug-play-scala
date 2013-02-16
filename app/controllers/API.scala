package controllers

import play.api.mvc._
import play.api.libs.json._
import models.Speaker
import models.Speakers

object API extends Controller with DBSession with JSonFormats {

 
  
  def speakers() = Action {
    withSession {
      Ok(Json.toJson(Speakers.all()))
    }
  }
}