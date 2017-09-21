package com.slack.jeanpokou.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private  val NUM_LIST_ITEMS = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        with(rv_numbers) {
            adapter = GreenAdapter(NUM_LIST_ITEMS, object : GreenAdapter.ListItemClickListener{
                override fun onListItemClick(clickedItemIndex: Int) {
                    toast("Item clicked is : $clickedItemIndex")
                }
            })
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()

        }


    }
}
