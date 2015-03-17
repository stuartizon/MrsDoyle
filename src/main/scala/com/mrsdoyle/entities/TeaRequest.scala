package com.mrsdoyle.entities

case class TeaRequest(token:String, team_id:String, team_domain:String, channel_id: String, channel_name:String, user_id:String, user_name:String, command:String, text:String)