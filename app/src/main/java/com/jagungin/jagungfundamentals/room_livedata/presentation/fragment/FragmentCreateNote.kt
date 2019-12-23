package com.jagungin.jagungfundamentals.room_livedata.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jagungin.jagungfundamentals.R
import com.jagungin.jagungfundamentals.room_livedata.presentation.viewmodel.NoteViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_create_note.*
import org.koin.android.architecture.ext.viewModel
import java.util.*

/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */
class FragmentCreateNote: Fragment() {

    private val noteViewModel by viewModel<NoteViewModel>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSaveButton()
    }

    private fun initSaveButton() {
        create_note_button.setOnClickListener{
            val disposable = Observable.just(true)
                .observeOn(Schedulers.io())
                .map { note_text_field.text.toString() }
                .doOnNext { noteViewModel.saveNote(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{note_text_field.setText("")}
            compositeDisposable.add(disposable)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }

    companion object{

        fun newInstance(): FragmentCreateNote{
            return FragmentCreateNote()
        }
    }

}