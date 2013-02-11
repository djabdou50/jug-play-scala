package controllers


import play.api.templates.Html
import views.html._

import models.Speakers
import models.Events

object Application extends MainAction  {

  def index = mainAction {
    database.withSession {
      
    	views.html.home(Events.all)
    }
  }

  def news() = mainAction {
    Html("News")
  }

  def event(nextEventId: Long) = mainAction {
    Html("Event: " + nextEventId)
  }

  def about = mainAction {
    views.html.about()
  }
  
  def members = mainAction {
    Html("Members")
  }

  def member(id: Long) = mainAction {
    Html("Member: " + id)
  }

  def polls = mainAction {
    Html("Polls")
  }
  
  def partners = mainAction {
    Html("Partners")
  }
  
  def partner(id: Long) = mainAction {
    Html("Partner id: " + id)
  }

  def speakers = mainAction {
    database.withSession {
      views.html.speakers(Speakers.all)
    }
  }

}