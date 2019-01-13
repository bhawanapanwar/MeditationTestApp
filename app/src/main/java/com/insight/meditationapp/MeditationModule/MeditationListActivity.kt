package com.insight.meditationapp.MeditationModule

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.insight.meditationapp.BaseActivity
import com.insight.meditationapp.R
import kotlinx.android.synthetic.main.activity_meditation_list.*

class MeditationListActivity : BaseActivity(), ListView {

    private val presenter = ListPresenter(this, ListIterator())
    private lateinit var mAdapter: ListAdapter
    private lateinit var mlist: MutableList<ListModel>
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditation_list)

        mlist = mutableListOf()
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.layoutManager = linearLayoutManager
        mAdapter = ListAdapter(this)
        recycler_view.adapter = mAdapter

        presenter.getData()
    }

    override fun showList(list: MutableList<ListModel>) {

    }

    override fun updateList(mlistArry: List<ListModel>) {

        mlist.addAll(mlistArry)
        mAdapter.setList(mlistArry)
    }


}
