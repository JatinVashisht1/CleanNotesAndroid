package com.jatinvashisht.cleannotes.di

import android.app.Application
import androidx.room.Room
import com.jatinvashisht.cleannotes.features.featureNote.data.local.database.NoteDatabase
import com.jatinvashisht.cleannotes.features.featureNote.data.local.repository.NoteRepositoryImpl
import com.jatinvashisht.cleannotes.features.featureNote.domain.repository.INoteRepository
import com.jatinvashisht.cleannotes.features.featureNote.domain.usecase.GetAllNotesUseCase
import com.jatinvashisht.cleannotes.features.featureNote.domain.usecase.InsertNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Singleton Object containing methods to resolve dependencies.
 *
 * Installed in *SingletonComponent*, therefore available in whole application.
 *
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Method to provide dependency of **[NoteDatabase]**.
     *
     * @param [app] Application object, provided by hilt.
     *
     * @return [NoteDatabase]
     * */
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase =
        Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME,
        )
            .build()


    /**
     * Method to provide dependency of [INoteRepository].
     *
     * @param [noteDatabase] of type [NoteDatabase], injected/provided by hilt.
     *
     * @return Object of [INoteRepository].
     * */
    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): INoteRepository =
        NoteRepositoryImpl(noteDatabase = noteDatabase)


    /**
     * Method to insert new note in database.
     *
     * @param [noteRepository] Object of [INoteRepository] to work with notes.
     *
     * @return Object of [InsertNoteUseCase].
     * */
    @Provides
    @Singleton
    fun provideInsertNoteUseCase(noteRepository: INoteRepository): InsertNoteUseCase =
        InsertNoteUseCase(noteRepository = noteRepository)

    /**
     * Method to get all notes in database.
     *
     * @param [noteRepository] Object of [INoteRepository] to work with notes.
     *
     * @return Object of [GetAllNotesUseCase].
     * */
    @Provides
    @Singleton
    fun provideGetAllNotesUseCase(noteRepository: INoteRepository): GetAllNotesUseCase =
        GetAllNotesUseCase(noteRepository = noteRepository)
}