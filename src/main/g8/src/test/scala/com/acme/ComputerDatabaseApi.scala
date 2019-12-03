package com.acme

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class MySimulation extends Simulation with ComputerDatabseApi {
  val baseUrl = "http://computer-database.gatling.io"

  val httpProtocol = http
    .baseUrl(baseUrl)
    .acceptHeader("*/*")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("pl-PL,pl;q=0.9,en-US;q=0.8,en;q=0.7")
    .acceptEncodingHeader("gzip, deflate, br")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36")

  val scenario = scenario("Computer database simulation 1")
    .exec(home)
    .pause(5)

  setUp(
    scenario.inject(atOnceUsers(1))
  ).protocols(httpProtocol)

}