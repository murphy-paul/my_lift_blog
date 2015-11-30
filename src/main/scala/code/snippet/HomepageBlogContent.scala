package code.snippet

import net.liftweb.util.Helpers._
import net.liftweb.util.HttpHelpers._
import net.liftweb.http.S

import code.model.Blog

class HomepageBlogContent {
  
  def render = ".blog-item" #> Blog.findAll.getOrElse(List()).map { item =>
      ".blog-link [href]" #> item.displayPath &
      ".heading *" #> item.headline &
      ".intro-text *" #> item.introText
    }
  
//  private def blogMarkup(blog: Blog) = <div itemscope itemtype="">{blog.headline}</li>
  
}