package com.jagungin.jagungfundamentals.room_livedata.presentation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jagungin.jagungfundamentals.R
import com.jagungin.jagungfundamentals.room_livedata.model.Note

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */
class NoteAdapter(private val itemLongClickListener: (Int) -> Unit) : RecyclerView.Adapter<NoteViewHolder>() {

    private var data: MutableList<Note> = mutableListOf()

    fun getDataAtPosition(position: Int): Note = data[position]

    fun setData(data: MutableList<Note>) {
        val diffResult = DiffUtil.calculateDiff(
            NoteDiffUtilCallback(this.data, data)
        )

        this.data = data
        diffResult.dispatchUpdatesTo(this)
    }

    fun updateData(data: MutableList<Note>) {
        val diffResult = DiffUtil.calculateDiff(
            NoteDiffUtilCallback(this.data, data)
        )

        this.data.clear()
        this.data.addAll(data)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_note, parent, false)

        return NoteViewHolder(itemView, itemLongClickListener)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            holder.bindData(data[position])
        }
    }

}