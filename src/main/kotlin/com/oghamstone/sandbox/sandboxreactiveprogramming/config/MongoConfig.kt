package com.oghamstone.sandbox.sandboxreactiveprogramming.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import com.mongodb.connection.ClusterSettings
import com.mongodb.reactivestreams.client.MongoClients
import com.oghamstone.sandbox.sandboxreactiveprogramming.school.student.StudentEntity
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import java.util.*


@Configuration
@EnableReactiveMongoRepositories(
    basePackageClasses = [StudentEntity::class])
class MongoConfig: AbstractReactiveMongoConfiguration() {

    @Value(value = "\${spring.data.mongodb.database}")
    private val database: String = ""

    @Value("\${spring.data.mongodb.uri}")
    private var mongoUri: String? = null

    override fun getDatabaseName(): String {
        return database
    }
    override fun configureClientSettings(builder: MongoClientSettings.Builder) {
        builder.applyConnectionString(ConnectionString(mongoUri!!))
    }

}