package com.mrsdoyle.core

import akka.actor.Actor
import com.mrsdoyle.entities.TeaRequest
import spray.routing.HttpService

import scala.concurrent.ExecutionContext

class TeaService extends Actor with HttpService {
  def actorRefFactory = context

  implicit def executionContext: ExecutionContext = actorRefFactory.dispatcher

  def receive = runRoute {
    teaRoute
  }

  val teaRoute =
    path("tea") {
      post {
        parameters('token, 'team_id, 'team_domain, 'channel_id, 'channel_name, 'user_id, 'user_name, 'command, 'text).as(TeaRequest) {
          request => complete(request.channel_id)
        }
      }
    }
}