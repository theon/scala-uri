package com.github.theon.urlutils

import org.scalatest._
import org.scalatest.matchers._
import com.github.theon.uri.Uri
import com.github.theon.uri.Uri._

class EncodingTests extends FlatSpec with ShouldMatchers {

  "URI paths" should "be percent encoded" in {
    val uri:Uri = "http://theon.github.com/üris-in-scàla.html"
    uri.toString should equal ("http://theon.github.com/%C3%BCris-in-sc%C3%A0la.html")
  }

  "Querystring parameters" should "be percent encoded" in {
    val uri = "http://theon.github.com/uris-in-scala.html" ? ("càsh" -> "£50") & ("©opyright" -> "false")
    uri.toString should equal ("http://theon.github.com/uris-in-scala.html?c%C3%A0sh=%C2%A350&%C2%A9opyright=false")
  }

  "Reserved characters" should "be percent encoded" in {
    val uri = "http://theon.github.com/uris-in-scala.html" ? ("reserved" -> ":/?#[]@!$&'()*+,;=")
    uri.toString should equal ("http://theon.github.com/uris-in-scala.html?reserved=%3A%2F%3F%23%5B%5D%40%21%24%26%27%28%29%2A%2B%2C%3B%3D")
  }
}
