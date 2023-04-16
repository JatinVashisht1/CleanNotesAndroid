package com.jatinvashisht.cleannotes.di

import android.app.Application
import androidx.room.Room
import com.jatinvashisht.cleannotes.features.featureNote.data.local.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Singleton Object containing methods to resolve dependencies.
 *
 * Installed in *SingletonComponent*, therefore available in whole application.
 * */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * Method to provide dependency of **NoteDatabase**.
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
}