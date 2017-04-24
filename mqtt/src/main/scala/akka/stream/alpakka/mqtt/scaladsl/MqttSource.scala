/*
 * Copyright (C) 2016-2017 Lightbend Inc. <http://www.lightbend.com>
 */
package akka.stream.alpakka.mqtt.scaladsl

import akka.Done
import akka.stream.alpakka.mqtt.{MqttMessage, MqttSourceSettings, MqttSourceStage}
import akka.stream.scaladsl.Source
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient

import scala.concurrent.Future

object MqttSource {

  /**
   * Scala API: create an [[MqttSource]] with a provided bufferSize.
   */
  def apply(settings: MqttSourceSettings, bufferSize: Int): Source[MqttMessage, Future[Option[IMqttAsyncClient]]] =
    Source.fromGraph(new MqttSourceStage(settings, bufferSize))

}
