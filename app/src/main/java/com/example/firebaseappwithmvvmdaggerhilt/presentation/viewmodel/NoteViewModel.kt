package com.example.firebaseappwithmvvmdaggerhilt.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaseappwithmvvmdaggerhilt.data.models.Notes
import com.example.firebaseappwithmvvmdaggerhilt.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
): ViewModel() {

    //for getting live data
    private val _notes = MutableLiveData<List<Notes>>()
    //for exposing live data
    val note: LiveData<List<Notes>>
                get()=_notes

    fun getNotes(){
        _notes.value = repository.getNotes()
    }
}