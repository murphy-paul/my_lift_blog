package code.model

import net.liftweb.common.Box
import net.liftweb.common.Full

case class Blog(headline: String, displayPath: String, introText: String, body: String)

/**
 * TODO: The datasource should be add as traits
 */
object Blog {
  
  private val blogs = List(
      Blog(
          "Continous Integration with codeship", 
          "continous-integration-with-codeshop", 
          "A how to on CI/CD with codeship for liftweb", 
          "A how to on CI/CD with codeship for liftweb"),
      Blog(
          "Property-based testing", 
          "property-based-testing--what-is-it?", 
          "Property based testing frameworks run the same test over and over, with generated input. This is in contrast to example based testing, which is what we typicallly do when we write unit tests.", 
          "Property based testing frameworks run the same test over and over, with generated input. This is in contrast to example based testing, which is what we typicallly do when we write unit tests."),
      Blog(
          "Dynamic Content",
          "dynamic-content",
          "Dynamic Content",
"""
##How to serve dynamic content from your lift web application

Coming from a MVC perspective, when I first started to develop using lift, my initial thoughts on how to serve dynamic content was to setup rewrite rules.
The below snipet is an example of how to do that.


    LiftRules.statelessRewrite.append {
      case RewriteRequest(
            ParsePath(List("article",slug),_,_,_),_,_) =>
               if(Blog.findByDisplayPath(slug).isDefined) {
                RewriteResponse("content" :: Nil, Map("slug" -> slug) )
               } else {
                 RewriteResponse("index" :: Nil)
               }
    }

I also consider rest, and following a SPA design to dynamically load the content on the first end.

But none of this options felt write. Liftweb is a view first framework, so to go down either of the above mentioned routes felt like a failure in my exploration of the lift framework. Surely there had to be a more liftweb  approach to solving the problem?

I came across a blog site by [Richard Dallay](http://richard.dallaway.com/lift-26-release/) where he introduced me to Menu.param.

The solution is to add the dynamic content to the sitemap, which has lots of benifits

###Adding the found object to request scope
Again, not knowing the liftweb framework well, my first instinct was to add the Model object into the Request context in order to be able to use it throught that request. But once again, liftweb has already considered such things.

With the above approach, using the SiteMap to define the route*, you can now define a snippet class that takes a the case class as a constructor parameter.


    class BlogPage(blog: Blog) {
        def render: = ... // use the blog object in a meaninful way.
    }

"""
          )
    ) 
  
  def findAll:Box[List[Blog]] = Full(blogs)
  
  def findByDisplayPath(displayPath: String):Box[Blog] = blogs.find(x => x.displayPath == displayPath )
  
}