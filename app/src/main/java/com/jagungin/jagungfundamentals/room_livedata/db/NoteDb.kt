package com.jagungin.jagungfundamentals.room_livedata.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jagungin.jagungfundamentals.room_livedata.Constants

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */

@Entity(
    tableName = Constants.Table.NOTE
)
class NoteDb(
    @PrimaryKey val id: String,
    val content: String
)