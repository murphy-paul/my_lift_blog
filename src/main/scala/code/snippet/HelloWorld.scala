package code
package snippet

import net.liftweb.util.Helpers._
import net.liftweb.http.S
import java.util.Date
import net.liftweb.sitemap.Loc.Template
import net.liftweb.http.Templates
import net.liftweb.http.LiftRules
import net.liftweb.common.Box
import java.io.File
import java.net.URL
import java.nio.file.Files
import code.actor.BlogEntries

class HelloWorld {
  lazy val date = new Date()
  
  
  def processFolderContent(url: URL):List[String] = 
    new File(url.getFile).listFiles().map { x => x.getName }.toList
    
  def listBlogs = {
    val content:List[String] = 
      LiftRules.getResource("/templates-hidden/blogs").map { x => processFolderContent(x) }.get
      
      <ul>{fileList(content)}</ul>
  }
    
  private def fileList(content:List[String]) = {
    for {
      file <- content
    } yield <li>{file}</li>
  }

  // replace the contents of the element with id "time" with the date
  def howdy = "#time *" #> date.toString

}