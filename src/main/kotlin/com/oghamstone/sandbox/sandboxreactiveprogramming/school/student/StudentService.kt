package com.oghamstone.sandbox.sandboxreactiveprogramming.school.student

import jakarta.annotation.PostConstruct
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class StudentService(var reactiveMongoTemplate: ReactiveMongoTemplate) {


    fun generateData() {
        for (i in 0..5000) {
            var student = Student()
            student.name = "Name $i"
            reactiveMongoTemplate.save(student).subscribe()
            println(i)
        }
        println("finished generating data")
    }

    fun get(id: String): Mono<Student> {
        return reactiveMongoTemplate.findById(id, Student::class.java)
    }

    fun getAll(): Flux<Student> {
        return reactiveMongoTemplate.findAll(Student::class.java)
    }
}