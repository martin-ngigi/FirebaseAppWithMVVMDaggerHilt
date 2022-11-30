package com.example.firebaseappwithmvvmdaggerhilt.data.models

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Note(
    var id: String = "",
    val text: String = "",
    @ServerTimestamp
    val date: Date = Date(),
)