package com.netaporter.uri.parsing

import org.parboiled2._
import com.netaporter.uri._
import com.netaporter.uri.config.UriConfig

class JDBCUriParser(i: ParserInput, conf: UriConfig) extends DefaultUriParser(i, conf) {

  override def _scheme: Rule1[String] = rule {
    capture("jdbc:" ~ oneOrMore(CharPredicate.AlphaNum))
  }

}