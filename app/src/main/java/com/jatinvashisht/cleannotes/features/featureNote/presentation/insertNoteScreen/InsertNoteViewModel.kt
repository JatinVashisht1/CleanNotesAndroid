package com.jatinvashisht.cleannotes.features.featureNote.presentation.insertNoteScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jatinvashisht.cleannotes.features.featureNote.domain.model.NoteModel
import com.jatinvashisht.cleannotes.features.featureNote.domain.usecase.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class InsertNoteViewModel @Inject constructor(private val insertNoteUseCase: InsertNoteUseCase) :
    ViewModel() {

    private val _noteTitleTextState = mutableStateOf<String>("")
    val noteTitleTextState: State<String> = _noteTitleTextState

    private val _noteBodyTextState = mutableStateOf<String>("")
    val noteBodyTextState: State<String> = _noteBodyTextState

    companion object {
        const val TAG = "InsertNoteViewModel"
    }

    fun onTitleTextFieldValueChange(newTitle: String) {
        _noteTitleTextState.value = newTitle
    }

    fun onBodyTextFieldValueChange(newBody: String) {
        _noteBodyTextState.value = newBody
    }

    fun insertNote() {
        viewModelScope.launch {
            insertNoteUseCase(NoteModel(title = "This is a random title.")).collectLatest {
                Timber.tag(TAG).d("Result is %s", it.toString())
            }
        }
    }
}