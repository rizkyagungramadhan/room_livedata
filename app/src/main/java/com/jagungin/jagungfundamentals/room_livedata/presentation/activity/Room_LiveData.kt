package com.jagungin.jagungfundamentals.room_livedata.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jagungin.jagungfundamentals.R
import com.jagungin.jagungfundamentals.room_livedata.presentation.fragment.FragmentCreateNote
import com.jagungin.jagungfundamentals.room_livedata.presentation.fragment.FragmentListNotes

class Room_LiveData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room__live_data)

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .replace(R.id.container_create_note, FragmentCreateNote.newInstance())
            .commit()

        fragmentManager.beginTransaction()
            .replace(R.id.container_list_note, FragmentListNotes.newInstance())
            .commit()

    }
}
