package com.netaporter.uri.config

import com.netaporter.uri.encoding.{NoopEncoder, UriEncoder, PercentEncoder}
import com.netaporter.uri.decoding.{PlusDecoder, PercentDecoder, UriDecoder}
import PercentEncoder._

/**
 * Date: 28/08/2013
 * Time: 21:31
 */
case class UriConfig(pathEncoder: UriEncoder,
                     queryEncoder: UriEncoder,
                     fragmentEncoder: UriEncoder,
                     pathDecoder: UriDecoder,
                     queryDecoder: UriDecoder,
                     fragmentDecoder: UriDecoder,
                     charset: String) {

  def withNoEncoding = copy(pathEncoder = NoopEncoder, queryEncoder = NoopEncoder, fragmentEncoder = NoopEncoder)

}

object UriConfig {

  val default = UriConfig(pathEncoder = PercentEncoder(PATH_CHARS_TO_ENCODE),
                          queryEncoder = PercentEncoder(QUERY_CHARS_TO_ENCODE),
                          fragmentEncoder = PercentEncoder(),
                          pathDecoder = PercentDecoder andThen PlusDecoder,
                          queryDecoder = PercentDecoder andThen PlusDecoder,
                          fragmentDecoder = PercentDecoder,
                          charset = "UTF-8")


  /**
   * Probably more than you need to percent encode. Wherever possible try to use a tighter Set of characters
   * to encode depending on your use case
   */
  val conservative = UriConfig(PercentEncoder(), PercentDecoder)

  def apply(encoder: UriEncoder = PercentEncoder(),
            decoder: UriDecoder = PercentDecoder,
            charset: String = "UTF-8"): UriConfig =
    UriConfig(encoder, encoder, encoder, decoder, decoder, decoder, charset)
}
