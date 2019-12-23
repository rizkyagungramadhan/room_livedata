package com.jagungin.jagungfundamentals.room_livedata.db

import androidx.lifecycle.LiveData
import com.jagungin.jagungfundamentals.room_livedata.model.Note
import java.util.*

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */
class NoteRepository(private val noteDao: NoteDao) {

    fun saveNote(content: String){
        val noteDb = NoteDb(id = generateUuid(), content = content)
        noteDao.insertNote(noteDb)
    }

    fun loadNotesLiveData(): LiveData<List<NoteDb>>{
        return noteDao.loadAllNotesLiveData()
    }

    private fun generateUuid(): String = UUID.randomUUID().toString()

    fun deleteNote(note: Note){
        noteDao.deleteNote(note.id)
    }
}