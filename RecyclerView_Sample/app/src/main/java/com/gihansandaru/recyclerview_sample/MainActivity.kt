package com.gihansandaru.recyclerview_sample

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list_cell.view.*

/**
 * Android Kotlin - RecyclerView Example
 * Gihan Sandaru 2019-05-14
 *
 * Dependancies -     implementation 'com.android.support:recyclerview-v7:28.0.0'
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = listOf(
            "One",
            "Two",
            "Three",
            "Four"
        )

        /*
        * Unlike Java - You can directly set layoutManager , no need of new keyword , directly initialize with (this)
        * */
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(items,this)
    }

    class ItemAdapter(val itemList: List<String>,val context:Context) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ItemAdapter.ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_cell, parent, false))
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        override fun onBindViewHolder(viewholder: ItemAdapter.ViewHolder, position: Int) {
            viewholder.item.text = itemList.get(position);
        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val item = view.txtItem
        }

    }
}

