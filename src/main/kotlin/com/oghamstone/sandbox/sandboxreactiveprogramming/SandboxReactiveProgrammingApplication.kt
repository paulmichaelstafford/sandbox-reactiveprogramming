package com.oghamstone.sandbox.sandboxreactiveprogramming

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class SandboxReactiveProgrammingApplication

fun main(args: Array<String>) {
	runApplication<SandboxReactiveProgrammingApplication>(*args)
}
