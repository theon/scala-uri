package com.netaporter.uri

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class TopPrivateDomainTests extends FlatSpec with Matchers {

  "Uri topPrivateDomain method" should " return true if url is a top private domain " in {
    val uri = Uri.parse("http://www.google.co.uk")
    uri.isTopPrivateDomain should equal(true)

    val uri1 = Uri.parse("http://google.co.uk")
    uri1.isTopPrivateDomain should equal(true)

    val uri2 = Uri.parse("http://www.mail.google.co.uk")
    uri2.isTopPrivateDomain should equal(false)

    val uri3 = Uri.parse("http://www.mail.google.co.uk")
    uri3.isTopPrivateDomain should equal(false)
  }

  it should "return false for relative URLs" in {
    val uri = Uri.parse("/blah")
    uri.isTopPrivateDomain should equal(false)
  }
}
