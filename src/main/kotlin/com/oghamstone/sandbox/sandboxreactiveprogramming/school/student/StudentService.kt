package com.oghamstone.sandbox.sandboxreactiveprogramming.school.student

import com.google.gson.Gson
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class StudentService(var template: ReactiveMongoTemplate, var mongoTemplate: MongoTemplate) {


//    @PostConstruct
    fun generateData() {
        for (i in 0..5000) {
            var student = Student()
            student.name = "Name $i"
            template.save(student).subscribe()
            println(i)
        }
        println("finished generating data")
    }


    fun test() {
        var boom: Flux<Student> = template.findAll(Student::class.java)
        var asd  = boom.collectList().block()
        var dss = get("6434026f90c24d0559d289b0").block()!!
        val asdad = "asd"
    }

    fun get(id: String): Mono<Student> {
        return template.findById(id, Student::class.java)
    }

    fun getAll(): Flux<Student> {
        return template.findAll(Student::class.java)
    }

    fun getNonReactive(id: String): Student {
        return mongoTemplate.findById(id, Student::class.java)!!
    }

    fun getAllNonReactive(): List<Student> {
        return mongoTemplate.findAll(Student::class.java)
    }
}