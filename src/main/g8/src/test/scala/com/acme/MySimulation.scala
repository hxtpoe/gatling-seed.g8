package com.acme

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

trait ComputerDatabaseApi extends Simulation {
  val home = http("home").get("/")
}