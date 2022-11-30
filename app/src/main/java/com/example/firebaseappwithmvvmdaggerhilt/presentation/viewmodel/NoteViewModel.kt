package com.example.firebaseappwithmvvmdaggerhilt.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaseappwithmvvmdaggerhilt.data.models.Note
import com.example.firebaseappwithmvvmdaggerhilt.data.repository.NoteRepository
import com.example.firebaseappwithmvvmdaggerhilt.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    val repository: NoteRepository
): ViewModel() {

    private val _notes = MutableLiveData<UiState<List<Note>>>()
    val note: LiveData<UiState<List<Note>>>
        get() = _notes

    private val _addNote = MutableLiveData<UiState<String>>()
    val addNote: LiveData<UiState<String>>
        get() = _addNote


    private val _updateNote = MutableLiveData<UiState<String>>()
    val updateNote: LiveData<UiState<String>>
        get() = _updateNote

    fun getNotes() {
        _notes.value = UiState.Loading
        repository.getNotes { _notes.value = it }
    }

    fun addNote(note: Note){
        _addNote.value = UiState.Loading
        repository.addNote(note) { _addNote.value = it }
    }

    fun updateNote(note: Note){
        _updateNote.value = UiState.Loading
        repository.updateNote(note) { _updateNote.value = it }
    }

}