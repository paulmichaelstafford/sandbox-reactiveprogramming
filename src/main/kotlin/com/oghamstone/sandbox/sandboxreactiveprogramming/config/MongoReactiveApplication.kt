package com.oghamstone.sandbox.sandboxreactiveprogramming.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration


@Configuration
class MongoReactiveApplication: AbstractReactiveMongoConfiguration() {

    @Value(value = "\${spring.data.mongodb.database}")
    private val database: String = ""

    @Bean
    fun mongoClient(): MongoClient {
        return MongoClients.create()
    }

    override fun getDatabaseName(): String {
        return database
    }

}