package com.example.spring_boot_crash_course.database.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import com.example.spring_boot_crash_course.database.model.Note

interface NoteRepository: MongoRepository<Note, ObjectId> {
    fun findByOwnerID(ownerId: ObjectId): List<Note>
}