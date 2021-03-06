package controllers

import play.api.libs.json.JsValue
import play.api.mvc.Action
import play.api.mvc.AnyContent
import play.api.mvc.Controller
import play.api.libs.json.JsResult
import play.api.mvc.SimpleResult
import play.api.mvc.Request
import play.api.libs.json.JsError
import controllers.JSonFormats._
import securesocial.core.Authorization

import securesocial.core.SecureSocial



trait JsonAction extends SecureSocial with JSonFormats {

  def JsonAction(f: JsValue => JsResult[SimpleResult]): Action[AnyContent] = Action {
    request =>
      try {
        request.body.asJson.map { json =>

          f(json).recoverTotal {
            e =>
              {
                BadRequest(jsValue(JsonError("Detected error: ", Some(JsError.toFlatJson(e)))))
              }
          }

        }.getOrElse {
          BadRequest(jsValue(JsonError("Expecting Json data", None)))
        }
      } catch {
        case e: Throwable => BadRequest(jsValue(JsonError(e.getMessage(), None)))
      }
  }
  
  
  def SecuredJsonAction(authorize: Authorization)(f: JsValue => JsResult[SimpleResult]): Action[AnyContent] = SecuredAction(true,authorize) {
    request =>
      try {
        request.body.asJson.map { json =>

          f(json).recoverTotal {
            e =>
              {
                BadRequest(jsValue(JsonError("Detected error: ", Some(JsError.toFlatJson(e)))))
              }
          }

        }.getOrElse {
          BadRequest(jsValue(JsonError("Expecting Json data", None)))
        }
      } catch {
        case e: Throwable => BadRequest(jsValue(JsonError(e.getMessage(), None)))
      }
  }
    
}