package com.jagungin.jagungfundamentals.room_livedata.presentation.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jagungin.jagungfundamentals.R
import com.jagungin.jagungfundamentals.room_livedata.presentation.recyclerview.NoteAdapter
import com.jagungin.jagungfundamentals.room_livedata.presentation.viewmodel.NoteViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list_note.*
import kotlinx.android.synthetic.main.layout_delete_item.*
import org.koin.android.architecture.ext.viewModel
/**
 * Created by Rizky Agung Ramadhan
( rizkyagungramadhan@gmail.com ) on 23/12/2019.
 */
class FragmentListNotes : Fragment() {

    private val noteViewModel by viewModel<NoteViewModel>()

    private var bottomSheetDialog: BottomSheetDialog? = null

    private val compositeDisposable = CompositeDisposable()

    private val adapter: NoteAdapter by lazy {
        NoteAdapter { position -> doOnLongItemClickListener(position) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_list_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListenNotesResult()
        initRecyclerView()
        initBottomSheetDialog()
    }

    private fun initListenNotesResult() {
        noteViewModel.listenNotesResult().observe(this, Observer {
            it?.let {
                adapter.updateData(it.toMutableList())
            }
        })
    }

    private fun initRecyclerView() {
        list_note.layoutManager = LinearLayoutManager(activity)
        list_note.adapter = adapter
    }

    private fun initBottomSheetDialog() {
        activity?.let {
            bottomSheetDialog = BottomSheetDialog(it)

            val view = LayoutInflater.from(it).inflate(R.layout.layout_delete_item, null)
            bottomSheetDialog?.setContentView(view)
        }
    }

    private fun doOnLongItemClickListener(position: Int) {
        bottomSheetDialog?.show()

        bottomSheetDialog?.delete_item_note_button?.setOnClickListener { view ->
            val note = adapter.getDataAtPosition(position)

            val disposable = Observable.just(true)
                .observeOn(Schedulers.io())
                .doOnNext { noteViewModel.deleteNote(note) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { bottomSheetDialog?.dismiss() }
            compositeDisposable.add(disposable)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }

    companion object {

        fun newInstance(): FragmentListNotes {
            return FragmentListNotes()
        }

    }

}