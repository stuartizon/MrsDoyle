
package com.mrsdoyle

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.kernel.Bootable
import com.mrsdoyle.core.TeaService
import com.typesafe.config.ConfigFactory
import spray.can.Http

class Main extends Bootable {
  val config = ConfigFactory.load()
  implicit val system = ActorSystem("mrs-doyle")

  val port = config.getInt("http-service.port")
  val adminPort = config.getInt("http-service.admin-port")

  def startup() = {
    val httpService = system.actorOf(Props[TeaService])
    IO(Http) ! Http.Bind(httpService, interface = "0.0.0.0", port = port)
  }

  def shutdown() = system.shutdown()
}

object Main extends App {
  new Main().startup
}