package com.jagungin.jagungfundamentals.room_livedata.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */
@Database(
    version = 1,
    entities = [
        NoteDb::class],
    exportSchema = false
)

abstract class Database: RoomDatabase(){
    abstract fun  noteDao(): NoteDao
}