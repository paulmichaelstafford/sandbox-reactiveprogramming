package com.oghamstone.sandbox.sandboxreactiveprogramming.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration


//@Configuration
//class MongoReactiveApplication: AbstractReactiveMongoConfiguration() {
//
//    @Value(value = "\${spring.data.mongodb.database}")
//    private val database: String = ""
//
//    @Value("\${spring.data.mongodb.uri}")
//    private var mongoUri: String? = null
//
//    @Bean
//    fun mongoClient(): MongoClient {
//        return MongoClients.create()
//    }
//
//    override fun getDatabaseName(): String {
//        return database
//    }
//    override fun configureClientSettings(builder: MongoClientSettings.Builder) {
//        builder.apply
//        builder.applyConnectionString(ConnectionString(mongoUri!!))
//    }
//
//}