package com.github.bagus.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrian.githubuserapi.data.User
import com.bumptech.glide.Glide
import com.github.bagus.DetailActivity
import com.github.bagus.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(private val list: MutableList<User>) : RecyclerView.Adapter<Holder>() {

    private lateinit var context: Context

    private var nama: String? = null
    private var idUser: String? = null
    private var URLUser: String? = null
    private var imgString: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        return Holder(LayoutInflater.from(context).inflate(R.layout.item_main, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = list[position]

        //ini buat deklarasi itemview
        val imgUser = holder.itemView.itemAvatar
        val name = holder.itemView.itemLogin
        val id = holder.itemView.itemDescription

        //ambil data
        nama = "${data.login}"
        idUser = "${data.id}"
        URLUser = "${data.followingUrl}"
        imgString = "${data.avatarUrl}"

        //ini buat manggil data
        name.text = nama
        id.text = idUser


        //ini buat manggil model gambar
        Picasso.get()
            .load(imgString)
            .into(imgUser)

        holder.itemView.setOnClickListener {
            val i = Intent(context,DetailActivity::class.java)
            i.putExtra("name", nama)
            i.putExtra("url", URLUser)
            i.putExtra("urlimg", imgString)

            context.startActivity(i)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}