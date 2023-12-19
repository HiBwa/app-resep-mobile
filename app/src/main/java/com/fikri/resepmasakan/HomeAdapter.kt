package com.fikri.resepmasakan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fikri.resepmasakan.model.ResponUser

class HomeAdapter (private val list: ArrayList<ResponUser>): RecyclerView.Adapter<HomeAdapter.GetDataUser>(){
    inner class  GetDataUser(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bind (user: ResponUser){
            with(itemView){
                val name = "nama: ${user.name}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetDataUser {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.fragment_home, parent, false)
        return GetDataUser(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: GetDataUser, position: Int) {
        holder.bind(list[position])

    }
}