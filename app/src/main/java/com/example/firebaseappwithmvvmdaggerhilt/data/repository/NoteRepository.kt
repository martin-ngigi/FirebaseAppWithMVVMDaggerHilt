package com.example.firebaseappwithmvvmdaggerhilt.data.repository

import com.example.firebaseappwithmvvmdaggerhilt.data.models.Notes

interface NoteRepository {
    //get notes from firebase
    fun getNotes(): List<Notes>
}