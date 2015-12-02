package code.snippet

import code.model.Blog

import net.liftweb._
import net.liftweb.util.Helpers._
import net.liftweb.common._
import net.liftweb.http._
import net.liftweb.sitemap._

/**
 * Snippet with functions for laying out the {@link code.model.Blog} page.
 * 
 * @author Paul Murphy
 */
class BlogPage(blog: Blog) {

  /**
   * Renders the header markup for a blog page.
   */
  def header = <li>{blog.headline}</li> 
  
}