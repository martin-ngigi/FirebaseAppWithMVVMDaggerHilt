package com.example.firebaseappwithmvvmdaggerhilt.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.firebaseappwithmvvmdaggerhilt.R
import com.example.firebaseappwithmvvmdaggerhilt.databinding.FragmentNoteDetailBinding

class NoteDetailFragment: Fragment(R.layout.fragment_note_detail){

    private lateinit var binding: FragmentNoteDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNoteDetailBinding.bind(view)
    }

}