package com.example.vkrecyclerview

import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vkrecyclerview.NewsListAdapter.NewsViewHolder

class NewsListAdapter : RecyclerView.Adapter<NewsViewHolder> {
    private var newsList: List<News>
    private var listener: ItemClickListener? = null

    constructor(newsList: List<News>) {
        this.newsList = newsList
    }

    constructor(newsList: List<News>, listener: ItemClickListener?) {
        this.newsList = newsList
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, null, false)
        val params = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = params
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        Glide.with(holder.accountPhotoUrl.context)
                .load(news.accountPhotoUrl)
                .into(holder.accountPhotoUrl)
        holder.accountName.text = news.accountName
        holder.date.text = news.date
        holder.newsText.text = news.newsText
        Glide.with(holder.postPhotoUrl.context)
                .load(news.postPhotoUrl)
                .into(holder.postPhotoUrl)
        if (news.liked == 1) {
            Glide.with(holder.likesUrl.context)
                    .load(R.drawable.likebluemin)
                    .into(holder.likesUrl)
            holder.likesCount.setTextColor(Color.parseColor("#006ba8"))
        } else {
            Glide.with(holder.likesUrl.context)
                    .load(R.drawable.likemin)
                    .into(holder.likesUrl)
            holder.likesCount.setTextColor(Color.parseColor("#979899"))
        }
        holder.likesCount.text = Integer.toString(news.likesCount)
        Glide.with(holder.commentsUrl.context)
                .load(news.commentsUrl)
                .into(holder.commentsUrl)
        holder.commentsCount.text = news.commentsCount.toString()
        Glide.with(holder.postsUrl.context)
                .load(news.postsUrl)
                .into(holder.postsUrl)
        holder.postsCount.text = news.postsCount.toString()
        Glide.with(holder.viewersUrl.context)
                .load(news.viewersUrl)
                .into(holder.viewersUrl)
        holder.viewersCount.text = news.viewersCount.toString()
        holder.itemView.setOnClickListener {
            if (listener != null) {
                listener!!.itemClick(position, news)
            }
        }
        holder.likesUrl.setOnClickListener { v ->
            if (listener != null) {
                if (news.liked == 1) {
                    if (SecondFragment.favoriteItems.contains(news)) {
                        SecondFragment.favoriteItems.remove(news)
                    }
                    news.liked = 0
                    news.likesCount = news.likesCount - 1
                    Glide.with(holder.likesUrl.context)
                            .load(R.drawable.likemin)
                            .into(holder.likesUrl)
                    holder.likesCount.text = Integer.toString(news.likesCount)
                    holder.likesCount.setTextColor(Color.parseColor("#979899"))
                    val toast = Toast.makeText(v.context,
                            "Like removed!",
                            Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
                } else {
                    news.liked = 1
                    news.likesCount = news.likesCount + 1
                    Glide.with(holder.likesUrl.context)
                            .load(R.drawable.likebluemin)
                            .into(holder.likesUrl)
                    holder.likesCount.text = Integer.toString(news.likesCount)
                    holder.likesCount.setTextColor(Color.parseColor("#006ba8"))
                    if (!SecondFragment.favoriteItems.contains(news)) {
                        SecondFragment.favoriteItems.add(news)
                    }
                    val toast = Toast.makeText(v.context,
                            "Liked!",
                            Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var accountPhotoUrl: ImageView
        var accountName: TextView
        var date: TextView
        var newsText: TextView
        var postPhotoUrl: ImageView
        var likesUrl: ImageView
        var likesCount: TextView
        var commentsUrl: ImageView
        var commentsCount: TextView
        var postsUrl: ImageView
        var postsCount: TextView
        var viewersUrl: ImageView
        var viewersCount: TextView

        init {
            accountPhotoUrl = itemView.findViewById(R.id.accountPhotoUrl)
            accountName = itemView.findViewById(R.id.accountName)
            date = itemView.findViewById(R.id.date)
            newsText = itemView.findViewById(R.id.newsText)
            postPhotoUrl = itemView.findViewById(R.id.postPhotoUrl)
            likesUrl = itemView.findViewById(R.id.likesUrl)
            likesCount = itemView.findViewById(R.id.likesCount)
            commentsUrl = itemView.findViewById(R.id.commentsUrl)
            commentsCount = itemView.findViewById(R.id.commentsCount)
            postsUrl = itemView.findViewById(R.id.postsUrl)
            postsCount = itemView.findViewById(R.id.postsCount)
            viewersUrl = itemView.findViewById(R.id.viewersUrl)
            viewersCount = itemView.findViewById(R.id.viewersCount)
        }
    }

    interface ItemClickListener {
        fun itemClick(position: Int, item: News?)
    }
}