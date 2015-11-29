package code.actor

import net.liftweb.actor.LiftActor
import net.liftweb.util.Schedule
import net.liftweb.util.Helpers._
import java.net.URL
import java.io.File
import net.liftweb.http.LiftRules

object BlogEntries extends LiftActor {
  
  case class DoIt()
  case class Stop()

  private var stopped = false

  def processFolderContent(url: URL):List[String] = 
    new File(url.getFile).listFiles().map { x => x.getName }.toList

  def messageHandler = {
    case DoIt if !stopped => {
      Schedule.schedule(this, DoIt, 10 seconds)
      println("Scheduled task")
      val content:List[String] = 
        LiftRules.getResource("/templates-hidden/blogs").map { x => processFolderContent(x) }.get
        
      content.foreach(println)

    }
    case Stop => {
      stopped = true
      println("Stopping scheduled tasks")
    }
  }
  
}