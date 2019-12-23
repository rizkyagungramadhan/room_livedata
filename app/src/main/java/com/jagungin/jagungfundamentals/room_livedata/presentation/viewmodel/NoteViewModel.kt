package com.jagungin.jagungfundamentals.room_livedata.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jagungin.jagungfundamentals.room_livedata.db.NoteRepository
import com.jagungin.jagungfundamentals.room_livedata.map
import com.jagungin.jagungfundamentals.room_livedata.model.Note

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */
class NoteViewModel(private val noteRepository: NoteRepository) : ViewModel() {

    private lateinit var notesResult: LiveData<List<Note>>

    init {
        subscribeNoteResult()
    }

    fun saveNote(content: String) {
        noteRepository.saveNote(content)
    }

    fun deleteNote(note: Note) {
        noteRepository.deleteNote(note)
    }

    fun listenNotesResult(): LiveData<List<Note>> {
        return notesResult
    }

    private fun subscribeNoteResult() {
        notesResult = noteRepository.loadNotesLiveData().map { data ->
            data.reversed().map { Note(it.id, it.content) }
        }
    }

}