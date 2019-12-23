package com.jagungin.jagungfundamentals.room_livedata

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.applicationContext

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */

class NoteApp: Application() {

    private val applicationModule = applicationContext {
        bean(Constants.Koin.CONTEXT_APP_DI) { this@NoteApp.applicationContext }
    }

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin(
            this,
            listOf(
                applicationModule,
                noteModule
            )
        )
    }
}