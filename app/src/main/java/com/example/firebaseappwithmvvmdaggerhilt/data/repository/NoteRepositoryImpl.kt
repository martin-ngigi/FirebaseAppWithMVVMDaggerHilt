package com.example.firebaseappwithmvvmdaggerhilt.data.repository

import com.example.firebaseappwithmvvmdaggerhilt.data.models.Notes
import com.example.firebaseappwithmvvmdaggerhilt.util.UIStates
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class NoteRepositoryImpl(
    private val database: FirebaseFirestore
): NoteRepository {
    override fun getNotes(): UIStates<List<Notes>>{
        val data =  arrayListOf(
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

        if (data.isNullOrEmpty()){
            return UIStates.Failure("Data is Empty")
        }
        //else
        return UIStates.Success(data)
    }
}