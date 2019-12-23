package com.jagungin.jagungfundamentals.room_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */
fun <X, Y> LiveData<X>.map(func: (source: X) -> Y): LiveData<Y> = Transformations.map(this, func)