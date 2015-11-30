package code.model

case class Blog(headline: String, displayPath: String, introText: String, body: String)

object Blog {
  
  def findAll:Option[List[Blog]] = 
    Some(List(
      Blog(
          "Continous Integration with codeship", 
          "/continous-integration-with-codeshop", 
          "A how to on CI/CD with codeship for liftweb", 
          "A how to on CI/CD with codeship for liftweb"),
      Blog(
          "Property-based testing", 
          "/property-based-testing--what-is-it?", 
          "Property based testing frameworks run the same test over and over, with generated input. This is in contrast to example based testing, which is what we typicallly do when we write unit tests.", 
          "Property based testing frameworks run the same test over and over, with generated input. This is in contrast to example based testing, which is what we typicallly do when we write unit tests.")
    ))
  
}