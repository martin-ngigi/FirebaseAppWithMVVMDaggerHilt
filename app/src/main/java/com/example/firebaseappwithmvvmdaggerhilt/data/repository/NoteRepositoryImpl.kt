package com.example.firebaseappwithmvvmdaggerhilt.data.repository

import com.example.firebaseappwithmvvmdaggerhilt.data.models.Notes

class NoteRepositoryImpl: NoteRepository {
    override fun getNotes(): List<Notes> {
        return arrayListOf()

    }
}