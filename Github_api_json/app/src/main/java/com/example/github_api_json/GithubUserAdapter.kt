package com.example.github_api_json

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*

class GithubUserAdapter(private val githubUsers : ArrayList<GithubUser>) : RecyclerView.Adapter<GithubUserAdapter.GithubViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)
            = GithubViewHolder(LayoutInflater.from(p0?.context).inflate(R.layout.item_row,p0,false))


    override fun getItemCount() = githubUsers.size

    override fun onBindViewHolder(p0: GithubViewHolder, p1: Int) {
        p0.bind(githubUsers[p1])
    }

    class GithubViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        fun bind(githubUser: GithubUser){
            itemView.tvLogin.text = githubUser.login
            itemView.tvUrl.text = githubUser.url
            itemView.tvScore.text = githubUser.score.toString()

        }
    }
}