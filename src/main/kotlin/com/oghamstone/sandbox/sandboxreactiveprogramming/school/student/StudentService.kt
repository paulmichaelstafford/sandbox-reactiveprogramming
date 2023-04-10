package com.oghamstone.sandbox.sandboxreactiveprogramming.school.student

import com.google.gson.Gson
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class StudentService(var template: ReactiveMongoTemplate) {


    @PostConstruct
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
}