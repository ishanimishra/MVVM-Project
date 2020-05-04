package com.example.repoinfo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.repoinfo.R
import com.example.repoinfo.model.UserDetails
import kotlinx.android.synthetic.main.repo_list.view.*


class UserAdapter(var users : List<UserDetails>, var clickListener: onUserItemClickListener) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.repo_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = users.size

    fun setResults(results: UserDetails) {
        this.users = listOf(results)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
//        holder.view.textViewName.text = user.name
//        holder.view.textViewLogin.text = user.owner.login
//        holder.view.textViewDescription.text = user.description
        holder.initialize(users[position],clickListener)

        Glide.with(holder.view.context).load(user.owner.avatar_url).into(holder.view.imageView)
    }

    class UserViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        var UserName = view.name
        var UserLogin = view.login
        var UserDescription = view.description

        fun initialize(users: UserDetails, action: onUserItemClickListener) {
            UserName.text = "Name: " + users.name
            UserLogin.text = "Login: " + users.owner.login
            UserDescription.text = "Description: " + users.description
            //Glide.with(view.context).load(users.owner.avatar_url).into(imageView)

            view.setOnClickListener {
                action.onItemClick(users,adapterPosition)
            }
        }
    }
}

interface onUserItemClickListener {
    fun onItemClick(users: UserDetails, position: Int) {
    }
}
