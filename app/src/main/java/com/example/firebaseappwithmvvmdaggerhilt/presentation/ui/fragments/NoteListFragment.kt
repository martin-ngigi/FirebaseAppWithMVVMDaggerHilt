package com.example.firebaseappwithmvvmdaggerhilt.presentation.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.firebaseappwithmvvmdaggerhilt.R
import com.example.firebaseappwithmvvmdaggerhilt.data.models.Note
import com.example.firebaseappwithmvvmdaggerhilt.databinding.FragmentNoteDetailBinding
import com.example.firebaseappwithmvvmdaggerhilt.databinding.FragmentNoteListBinding
import com.example.firebaseappwithmvvmdaggerhilt.presentation.ui.adapters.NoteListingAdapter
import com.example.firebaseappwithmvvmdaggerhilt.presentation.viewmodel.NoteViewModel
import com.example.firebaseappwithmvvmdaggerhilt.util.UiState
import com.example.firebaseappwithmvvmdaggerhilt.util.hide
import com.example.firebaseappwithmvvmdaggerhilt.util.show
import com.example.firebaseappwithmvvmdaggerhilt.util.toast

import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class NoteListingFragment : Fragment() {

    val TAG: String = "NoteListingFragment"
    lateinit var binding: FragmentNoteListBinding
    val viewModel: NoteViewModel by viewModels()
    val adapter by lazy {
        NoteListingAdapter(
            onItemClicked = { pos, item ->
                findNavController().navigate(R.id.action_noteListFragment_to_noteDetailFragment3, Bundle().apply {
                    putString("type", "view") //passing data between fragments
                    putParcelable("note", item)
                })
            },
            onEditClicked = { pos, item ->
                findNavController().navigate(R.id.action_noteListFragment_to_noteDetailFragment3, Bundle().apply {
                    putString("type", "edit") //passing data between fragments
                    putParcelable("note", item)
                })
            },
            onDeleteClicked = { pos, item ->

            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_noteListFragment_to_noteDetailFragment3, Bundle().apply {
                putString("type", "create") //passing data between fragments
            })
        }
        viewModel.getNotes()
        viewModel.note.observe(viewLifecycleOwner) { state ->
            when(state){
                is UiState.Loading -> {
                    binding.progressBar.show()
                }
                is UiState.Failure -> {
                    binding.progressBar.hide()
                    toast(state.error)
                }
                is UiState.Success -> {
                    binding.progressBar.hide()
                    adapter.updateList(state.data.toMutableList())
                }
            }
        }
    }
}