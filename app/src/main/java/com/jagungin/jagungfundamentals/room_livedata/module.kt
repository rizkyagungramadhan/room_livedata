package com.jagungin.jagungfundamentals.room_livedata

import androidx.room.Room
import com.jagungin.jagungfundamentals.room_livedata.db.Database
import com.jagungin.jagungfundamentals.room_livedata.db.NoteRepository
import com.jagungin.jagungfundamentals.room_livedata.presentation.viewmodel.NoteViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */

val noteModule = applicationContext {
    //Create Database

    bean(name = Constants.Koin.DATABASE_DI) {
        Room
            .databaseBuilder(
                get(Constants.Koin.CONTEXT_APP_DI),
                Database::class.java,
                Constants.Table.DB_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

//Create Note Repository
    bean { get<Database>(Constants.Koin.DATABASE_DI).noteDao() }
    bean { NoteRepository(get()) }

//Create NoteViewModel
    viewModel { NoteViewModel(get()) }
}