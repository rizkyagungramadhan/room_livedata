package com.jagungin.jagungfundamentals.room_livedata.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jagungin.jagungfundamentals.room_livedata.Constants

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */
@Dao
interface NoteDao {

    @Query("SELECT * FROM ${Constants.Table.NOTE}")
    fun loadAllNotesLiveData(): LiveData<List<NoteDb>>

    @Insert
    fun insertNote(note: NoteDb)

    @Query("DELETE FROM ${Constants.Table.NOTE} WHERE id=:noteId")
    fun deleteNote(noteId: String)
}