package controllers

import play.api.libs.json._
import models._
import java.sql.Timestamp
import play.api.mvc.Action
import play.api.mvc.AnyContent

object JSonFormats extends JSonFormats {

  implicit def errorFormat = Json.format[JsonError]

  def jsValue(err: JsonError): JsValue = Json.toJson(err)

}

trait JSonFormats {

  //  implicit val speakerReads = new Format[Speaker] {
  //    def writes(s: Speaker) : JsValue = {
  //      Json.obj(
  //          "name" -> s.photourl.filterNot(i=>i=="").orElse(Some("zob")))
  //    }
  //    def reads(js: JsValue): JsResult[Speaker] = {
  //      JsSuccess(null)
  //    }
  //  }

  implicit val formatTimestamp = new Format[Timestamp] {
    def writes(ts: Timestamp): JsValue = JsString(ts.toString())
    def reads(ts: JsValue): JsResult[Timestamp] = {
      try {
        JsSuccess(Timestamp.valueOf(ts.as[String]))
      } catch {
        case e: IllegalArgumentException => JsError("Unable to parse timestamp")
      }
    }
  }

  implicit val speakerFormat = Json.format[Speaker]

  implicit val talkFormat = Json.format[Talk]

  implicit val userFormat = Json.format[User]

  implicit val newsFormat = Json.format[News]

  implicit val eventReads = Json.format[Event]

  implicit val yearpartnerReads = Json.format[Yearpartner]

  implicit val testReads = Json.format[Test]

}

case class JsonError(message: String, e: Option[JsObject]) 
