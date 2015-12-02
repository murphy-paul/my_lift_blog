package bootstrap.liftweb

import net.liftweb._
import util._
import Helpers._
import common._
import http._
import sitemap._
import Loc._
import net.liftmodules.JQueryModule
import net.liftweb.http.js.jquery._
import code.model.Blog

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages("code")

    // Build SiteMap
    val entries = 
      List(
        Menu.i("Home") / "index",
        Menu.param[Blog]("blog", "Blog page", 
                         s => Blog.findByDisplayPath(s), 
                         bi => bi.displayPath) / "blog" >> LocGroup("blog") >> Hidden
	    )

    // set the sitemap.  Note if you don't want access control for
    // each page, just comment this line out.
    LiftRules.setSiteMap(SiteMap(entries:_*))
    
//    lazy val articleLoc = Menu.param[Blog]("blog", "Blog Detail Page", slug => Blog.findByDisplayPath(slug), blog => blog.displayPath) / "content" / *
    
        //Rewrite rules for search
//    LiftRules.statelessRewrite.append {
//      case RewriteRequest(
//            ParsePath(List("article",slug),_,_,_),_,_) =>
//               if(Blog.findByDisplayPath(slug).isDefined) {
//                RewriteResponse("content" :: Nil, Map("slug" -> slug) )
//               } else {
//                 RewriteResponse("index" :: Nil)
//               }
//
//    }


    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    //Init the jQuery module, see http://liftweb.net/jquery for more information.
    LiftRules.jsArtifacts = JQueryArtifacts
    JQueryModule.InitParam.JQuery=JQueryModule.JQuery191
    JQueryModule.init()
    
  }
}