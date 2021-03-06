package com.georgiyangeni.firstandroidapp.ui.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.georgiyangeni.firstandroidapp.R
import com.georgiyangeni.firstandroidapp.entity.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var userList: List<User> = emptyList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val avatarImageView = itemView.findViewById<ImageView>(R.id.avatarImageView)
        val userNameTextView = itemView.findViewById<TextView>(R.id.userNameTextView)
        val groupNameTextView = itemView.findViewById<TextView>(R.id.groupNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int /* used for getItemViewType */): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.avatarImageView)
            .load(userList[position].avatarUrl)
            .placeholder(R.mipmap.ic_launcher)
            .circleCrop()
            .into(holder.avatarImageView)
        holder.userNameTextView.text = userList[position].userName
        holder.groupNameTextView.text = userList[position].groupName
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}