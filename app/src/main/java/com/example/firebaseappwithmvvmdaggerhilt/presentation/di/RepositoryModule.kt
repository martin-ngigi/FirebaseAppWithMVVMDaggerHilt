package com.example.firebaseappwithmvvmdaggerhilt.presentation.di

import com.example.firebaseappwithmvvmdaggerhilt.data.repository.NoteRepository
import com.example.firebaseappwithmvvmdaggerhilt.data.repository.NoteRepositoryImp
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun providesNoteRepository(
        database: FirebaseFirestore
    ): NoteRepository{
        return NoteRepositoryImp(database)
    }
}