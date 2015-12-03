package code.snippet

import org.scalatest.FlatSpec

import code.model.Blog

class BlogPageTest extends FlatSpec {
  
  private val blog =       
    Blog(
          "Dynamic Content",
          "dynamic-content",
          "Dynamic Content",
          """
##How to serve dynamic content from your lift web application
 
 
this is a paragraph."""
  )

  
  "BlogPage header" should " render header element" in {
    val expected = <h1 class="post-title">heading</h1>
    val inputNodeSeq = <h1 class="post-title"></h1>
    val actual = new BlogPage(Blog("heading","","","")).header(inputNodeSeq)
    
    assert(actual.toString == expected.toString)
  }
  
  it should "Render the body markdown" in {
    val actual = new BlogPage(blog).body
    
    println(actual)
    
  }
  
}