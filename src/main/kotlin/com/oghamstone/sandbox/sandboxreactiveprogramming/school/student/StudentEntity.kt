package com.oghamstone.sandbox.sandboxreactiveprogramming.school.student

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface StudentEntity : ReactiveMongoRepository<Student, String>
