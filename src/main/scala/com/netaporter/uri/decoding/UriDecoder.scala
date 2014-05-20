package com.netaporter.uri.decoding

import com.netaporter.uri.Parameters
import Parameters._
import com.netaporter.uri.Parameters

/**
 * Date: 28/08/2013
 * Time: 21:01
 */
trait UriDecoder {
  def decode(u: String): String

  def decodeTuple(kv: Param) =
    decode(kv._1) -> decode(kv._2)


  def andThen( d: UriDecoder) : UriDecoder = {
     val base = this
     new UriDecoder {
        override def decode(u: String): String = d.decode(base.decode(u))
     }
  }
}
