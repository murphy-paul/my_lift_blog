package code.snippet

import org.scalatest.FlatSpec

import code.model.Blog

class BlogPageTest extends FlatSpec {
  
  "BlogPage header" should " render header element" in {
    assert(new BlogPage(Blog("heading","","","")).header == <li>heading</li>)
  }
  
}