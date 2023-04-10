package com.oghamstone.sandbox.sandboxreactiveprogramming.school.student

import com.google.gson.Gson
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono


@Service
class StudentService(var template: ReactiveMongoTemplate) {

    companion object {
        const val COLLECTION = "students"
        val GSON = Gson()
    }

    @PostConstruct
    fun generateData() {
        for (i in 0..5) {
            var student = Student()
            student.name = "Name $i"
            template.save(student).subscribe()
        }
    }
}