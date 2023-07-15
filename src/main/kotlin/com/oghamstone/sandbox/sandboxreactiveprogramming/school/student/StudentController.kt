package com.oghamstone.sandbox.sandboxreactiveprogramming.school.student

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/student")
class StudentController(var studentService: StudentService) {

    @GetMapping("/generateData")
    fun generateData() {
        studentService.generateData()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): Mono<Student> {
        return studentService.get(id)
    }

    @GetMapping("/getAll")
    fun getAll(): Flux<Student> {
        return studentService.getAll()
    }
}