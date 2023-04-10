package com.oghamstone.sandbox.sandboxreactiveprogramming.school.student

import com.google.gson.Gson
import jakarta.annotation.PostConstruct
import org.bson.Document
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service


@Service
class StudentService(val mongoTemplate: MongoTemplate) {

    companion object {
        const val COLLECTION = "students"
    }

    @PostConstruct
    fun boom() {
        var gson = Gson()
        for (i in 0..5) {
            var student = Student()
            student.name = "Name $i"
            mongoTemplate.getCollection(COLLECTION).insertOne(Document.parse(gson.toJson(student)))
        }
    }
}