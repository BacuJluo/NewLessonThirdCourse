package com.home.newlessonthirdcourse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.home.newlessonthirdcourse.main.OnRecycleIViewItemClickListener

class UserAdapter(private val onItemClickListener:OnRecycleIViewItemClickListener) : ListAdapter<GithubUser,UserAdapter.GithubUserViewHolder>(GithubUserItemCallback)
     {

    var users: List<GithubUser> = mutableListOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        return  GithubUserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        )
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    inner class GithubUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvLogin by lazy { itemView.findViewById<TextView>(R.id.tvUserLogin) }
        //private val userCard by lazy { itemView.findViewById<TextView>(R.id.emailCardView) }

        fun bind(item: GithubUser) = with(item) {
            tvLogin.text = login
            tvLogin.setOnClickListener {
                onItemClickListener.onItemViewClick(item)
            }
        }
    }

}

object GithubUserItemCallback : DiffUtil.ItemCallback<GithubUser>() {
    override fun areContentsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
        return oldItem == newItem
    }
}




