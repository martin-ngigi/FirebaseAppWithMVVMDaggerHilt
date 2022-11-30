package com.example.firebaseappwithmvvmdaggerhilt.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.firebaseappwithmvvmdaggerhilt.R
import com.example.firebaseappwithmvvmdaggerhilt.databinding.FragmentNoteListBinding

class NoteListFragment: Fragment(R.layout.fragment_note_list){

    private lateinit var binding: FragmentNoteListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNoteListBinding.bind(view)
    }


}