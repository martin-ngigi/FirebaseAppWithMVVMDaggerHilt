package com.example.firebaseappwithmvvmdaggerhilt.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.firebaseappwithmvvmdaggerhilt.R
import com.example.firebaseappwithmvvmdaggerhilt.databinding.FragmentNoteListBinding
import com.example.firebaseappwithmvvmdaggerhilt.presentation.viewmodel.NoteViewModel
import com.example.firebaseappwithmvvmdaggerhilt.util.UIStates
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListFragment: Fragment(R.layout.fragment_note_list){

    private var TAG = "NoteListFragment"
    private lateinit var binding: FragmentNoteListBinding

    private val viewModel: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNoteListBinding.bind(view)

        viewModel.getNotes()
        //observe live data
        viewModel.note.observe(viewLifecycleOwner){state ->
            when(state){
                is UIStates.Loading ->{
                    Log.d(TAG, "Loading... ")
                }
                is UIStates.Success ->{
                    state.data.forEach{
                        Log.d(TAG, it.toString())
                    }
                }
                is UIStates.Failure ->{
                    Log.e(TAG, state.error.toString() )
                }
            }
        }
    }


}