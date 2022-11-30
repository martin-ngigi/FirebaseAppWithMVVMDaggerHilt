package com.example.firebaseappwithmvvmdaggerhilt.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.firebaseappwithmvvmdaggerhilt.R
import com.example.firebaseappwithmvvmdaggerhilt.databinding.FragmentNoteListBinding
import com.example.firebaseappwithmvvmdaggerhilt.presentation.viewmodel.NoteViewModel

class NoteListFragment: Fragment(R.layout.fragment_note_list){

    private var TAG = "NoteListFragment"
    private lateinit var binding: FragmentNoteListBinding

    private val viewModel: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNoteListBinding.bind(view)

        viewModel.getNotes()
        //observe live data
        viewModel.note.observe(viewLifecycleOwner){

        }
    }


}