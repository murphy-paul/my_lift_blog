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

class HelloWorld {
  lazy val date = new Date()

  // replace the contents of the element with id "time" with the date
  def howdy = "#time *" #> date.toString

}