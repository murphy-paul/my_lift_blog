package code.snippet

import code.model.Blog
import net.liftweb._
import net.liftweb.util.Helpers._
import net.liftweb.common._
import net.liftweb.http._
import net.liftweb.sitemap._
import net.liftweb.markdown.ActuariusTransformer

/**
 * Snippet with functions for laying out the {@link code.model.Blog} page.
 * 
 * @author Paul Murphy
 */
class BlogPage(blog: Blog) {
  
  val transformer = new ActuariusTransformer

  /**
   * Renders the header markup for a blog page.
   */
  def header = ".post-title *" #> blog.headline
  
  def body = {
    val string = transformer(blog.body)
    scala.xml.XML.loadString("<div class=\"post-body\">" + string + "</div>")
  }
  
}