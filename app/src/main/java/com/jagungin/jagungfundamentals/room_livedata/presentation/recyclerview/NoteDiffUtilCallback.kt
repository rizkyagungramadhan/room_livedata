package com.jagungin.jagungfundamentals.room_livedata.presentation.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.jagungin.jagungfundamentals.room_livedata.model.Note

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */
class NoteDiffUtilCallback(private val oldData: MutableList<Note>,
                           private val newData: MutableList<Note>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int,
                                 newItemPosition: Int): Boolean {
        return oldData[oldItemPosition].id == newData[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldData.size

    override fun getNewListSize(): Int = newData.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData[oldItemPosition] == newData[newItemPosition]
    }
}