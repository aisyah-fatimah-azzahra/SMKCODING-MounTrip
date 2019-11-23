package com.example.mountrip

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (
    private val context: Context,
    // context dia berlaku sebagai this (ini)
    private val items: List<Item>
    // variabel dari Item.kt bernama items
    ): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()
    //RecyclerView nya kita exstend ke parent (orang tua) nya RecyclerView yaitu RecyclerViewAdapter
    {
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun bindItem(item: Item) {

            }

            val name = view.findViewById<TextView>(R.id.tv_nama_gambar)
            // tv_name_team diganti dengan variabel name, kemudian mencari view dari id
            // list_item.xml bernama tv_nama_gambar
            val image = view.findViewById<ImageView>(R.id.iv_gambar);
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ) = ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_mountain, parent,
                false
            )
        )
        //menghubungkan antara layout list_item.xml dengan kotlin

        override fun getItemCount(): Int {
            return items.size
            //array yang dimuat dari string.xml
        }

        override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
            holder.bindItem(items[position])
        }
    }
