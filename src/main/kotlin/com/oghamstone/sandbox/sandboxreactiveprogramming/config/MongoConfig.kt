//package com.oghamstone.sandbox.sandboxreactiveprogramming.config
//
//import com.mongodb.ConnectionString
//import com.mongodb.MongoClientSettings
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration
//
//
//@Configuration
//class MongoConfig: AbstractMongoClientConfiguration() {
//
//    @Value(value = "\${spring.data.mongodb.database}")
//    private val database: String? = ""
//
//    @Value("\${spring.data.mongodb.uri}")
//    private var mongoUri: String? = null
//
//    override fun getDatabaseName(): String {
//       return database!!
//    }
//
//    override fun autoIndexCreation(): Boolean {
//        return true
//    }
//
//    override fun configureClientSettings(builder: MongoClientSettings.Builder) {
//        builder.applyConnectionString(ConnectionString(mongoUri!!))
//    }
//}