package com.jagungin.jagungfundamentals.room_livedata.presentation.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jagungin.jagungfundamentals.room_livedata.model.Note
import kotlinx.android.synthetic.main.item_note.view.*

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */
class NoteViewHolder(itemView: View?,
                     itemLongClickListener: (Int) -> Unit) : RecyclerView.ViewHolder(itemView!!) {
    init {
        itemView?.setOnLongClickListener {
            itemLongClickListener(adapterPosition)
            return@setOnLongClickListener true
        }
    }

    fun bindData(note: Note) {
        itemView.item_note_content.text = note.content
    }
}