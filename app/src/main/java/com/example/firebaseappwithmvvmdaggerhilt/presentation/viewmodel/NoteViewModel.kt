package com.example.firebaseappwithmvvmdaggerhilt.presentation.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaseappwithmvvmdaggerhilt.data.models.Notes
import com.example.firebaseappwithmvvmdaggerhilt.data.repository.NoteRepository
import com.example.firebaseappwithmvvmdaggerhilt.util.UIStates
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
): ViewModel() {

    //for getting live data
    private val _notes = MutableLiveData<UIStates<List<Notes>>>()
    //for exposing live data
    val note: LiveData<UIStates<List<Notes>>>
                get()=_notes

    fun getNotes(){
        _notes.value = UIStates.Loading
        Handler(Looper.getMainLooper()).postDelayed({
            _notes.value = repository.getNotes()
        }, 2000)
    }
}