package com.oghamstone.sandbox.sandboxreactiveprogramming.school.student

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Student {
    @Id
    var id: ObjectId? = null
    var name: String? = null
    var moduleId: Set<ObjectId>? = null
}