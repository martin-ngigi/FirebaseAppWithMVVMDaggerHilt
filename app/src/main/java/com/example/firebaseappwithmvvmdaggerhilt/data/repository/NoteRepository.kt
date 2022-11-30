package com.example.firebaseappwithmvvmdaggerhilt.data.repository

import com.example.firebaseappwithmvvmdaggerhilt.data.models.Notes
import com.example.firebaseappwithmvvmdaggerhilt.util.UIStates

interface NoteRepository {
    //get notes from firebase
    fun getNotes(): UIStates<List<Notes>>
}