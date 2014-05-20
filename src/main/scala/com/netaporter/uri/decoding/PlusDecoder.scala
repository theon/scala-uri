package com.netaporter.uri.decoding

object PlusDecoder extends UriDecoder {
   override def decode(u: String): String = u.replace('+', ' ')
}
