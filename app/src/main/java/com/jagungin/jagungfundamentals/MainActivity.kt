package com.jagungin.jagungfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jagungin.jagungfundamentals.room_livedata.presentation.activity.Room_LiveData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_room_live_data.setOnClickListener {
            startActivity(Intent(this, Room_LiveData::class.java))
        }
    }
}
