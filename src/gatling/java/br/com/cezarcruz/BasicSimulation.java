package br.com.cezarcruz;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.rampUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class BasicSimulation extends Simulation {

  final HttpProtocolBuilder httpProtocol = http
      .baseUrl("http://localhost:8080")
      .acceptHeader("application/json")
      .userAgentHeader("Carolina Reaper");

  ScenarioBuilder createTeacher = scenario("Creating Teacher")
      .exec(
          http("post")
              .post("/teachers").body(
                  StringBody("""
                      {
                          "name": "alberto roberto",
                          "contacts": [
                            {
                              "type": "PHONE",
                              "value": "88888888989"
                            },
                            {
                              "type": "EMAIL",
                              "value": "email@email.com"
                            }
                          ]
                        }
                                        """)).asJson()
              .header("content-type", "application/json")
              .check(status().in(201))
      );

  {
    setUp(
        createTeacher.injectOpen(
            constantUsersPerSec(2).during(10),
            constantUsersPerSec(5).during(15).randomized(),
            rampUsersPerSec(6).to(300).during(3 * 60)
        )
    ).protocols(httpProtocol);
  }

}
