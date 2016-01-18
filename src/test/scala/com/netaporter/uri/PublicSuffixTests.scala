package com.netaporter.uri

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class PublicSuffixTests extends FlatSpec with Matchers {

  "Uri publicSuffix method" should "match the longest public suffix" in {
    val uri = Uri.parse("http://www.google.co.uk/blah")
    uri.publicSuffix should equal(Some("co.uk"))
  }

  it should "return None for relative URLs" in {
    val uri = Uri.parse("/blah")
    uri.publicSuffix should equal(None)
  }
}
