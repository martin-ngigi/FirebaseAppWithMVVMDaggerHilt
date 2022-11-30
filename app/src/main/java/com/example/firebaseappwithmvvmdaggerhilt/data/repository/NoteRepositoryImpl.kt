package com.example.firebaseappwithmvvmdaggerhilt.data.repository

import com.example.firebaseappwithmvvmdaggerhilt.data.models.Notes
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class NoteRepositoryImpl(
    private val database: FirebaseFirestore
): NoteRepository {
    override fun getNotes(): List<Notes> {
        return arrayListOf(
            Notes(
                "1",
                "Note 1",
                Date()
            ),
            Notes(
                "2",
                "Note 2",
                Date()
            ),
            Notes(
                "4",
                "Note 3",
                Date()
            )

        )

    }
}