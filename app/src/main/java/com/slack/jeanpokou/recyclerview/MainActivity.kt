package com.slack.jeanpokou.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.LayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  val NUM_LIST_ITEMS = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(rv_numbers) {
            adapter = GreenAdapter(NUM_LIST_ITEMS)
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
        }


    }
}
