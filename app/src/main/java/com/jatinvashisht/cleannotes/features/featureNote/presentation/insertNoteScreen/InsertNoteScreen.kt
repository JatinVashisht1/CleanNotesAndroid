package com.jatinvashisht.cleannotes.features.featureNote.presentation.insertNoteScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.jatinvashisht.cleannotes.R
import com.jatinvashisht.cleannotes.core.MyPaddingValues

@Composable
fun InsertNoteScreen(insertNoteViewModel: InsertNoteViewModel = hiltViewModel()) {
    val titleText = insertNoteViewModel.noteTitleTextState.value
    val bodyText = insertNoteViewModel.noteBodyTextState.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                ReusableTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MyPaddingValues.medium),
                    textFieldValue = titleText,
                    onTextFieldValueChange = insertNoteViewModel::onTitleTextFieldValueChange,
                    placeholderText = stringResource(id = R.string.InsertNoteTitlePlaceholderText),
                    labelText = stringResource(id = R.string.InsertNoteTitleLabelText),
                )

                Spacer(modifier = Modifier.height(MyPaddingValues.medium))

                ReusableTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MyPaddingValues.medium),
                    textFieldValue = bodyText,
                    onTextFieldValueChange = insertNoteViewModel::onBodyTextFieldValueChange,
                    placeholderText = stringResource(id = R.string.InsertNoteBodyPlaceholderText),
                    labelText = stringResource(id = R.string.InsertNoteBodyLabelText)
                )
                Spacer(modifier = Modifier.height(MyPaddingValues.medium))
                Button(
                    onClick = insertNoteViewModel::insertNote, modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = MyPaddingValues.medium)
                ) {
                    Text("Insert note")
                }
            }
        }
    }
}

@Composable
fun ReusableTextField(
    modifier: Modifier = Modifier,
    textFieldValue: String,
    onTextFieldValueChange: (String) -> Unit,
    placeholderText: String,
    labelText: String,
) {
    OutlinedTextField(
        modifier = modifier,
        value = textFieldValue,
        onValueChange = onTextFieldValueChange,
        placeholder = {
            Text(text = placeholderText)
        },
        label = {
            Text(text = labelText)
        },
    )
}
