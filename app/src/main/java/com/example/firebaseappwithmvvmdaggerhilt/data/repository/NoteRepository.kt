package com.example.firebaseappwithmvvmdaggerhilt.data.repository

import com.example.firebaseappwithmvvmdaggerhilt.data.models.Note
import com.example.firebaseappwithmvvmdaggerhilt.util.UiState

interface NoteRepository {
    //get notes from firebase
    fun getNotes(result: (UiState<List<Note>>) -> Unit)
    fun addNote(note: Note, result: (UiState<String>) -> Unit)
}