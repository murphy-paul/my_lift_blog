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
          "Property based testing frameworks run the same test over and over, with generated input. This is in contrast to example based testing, which is what we typicallly do when we write unit tests.")
    ) 
  
  def findAll:Box[List[Blog]] = Full(blogs)
  
  def findByDisplayPath(displayPath: String):Box[Blog] = blogs.find(x => x.displayPath == displayPath )
  
}