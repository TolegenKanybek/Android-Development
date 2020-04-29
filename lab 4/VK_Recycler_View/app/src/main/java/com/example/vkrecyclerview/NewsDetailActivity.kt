package com.example.vkrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class NewsDetailActivity : AppCompatActivity() {
    lateinit var accountPhotoUrl: ImageView
    lateinit var accountName: TextView
    lateinit var date: TextView
    lateinit var newsText: TextView
    lateinit var postPhotoUrl: ImageView
    lateinit var likesUrl: ImageView
    lateinit var likes: TextView
    lateinit var userLike1: ImageView
    lateinit var userLike2: ImageView
    lateinit var likesDetail: TextView
    lateinit var showCom //private String showCom;
            : TextView
    lateinit var userComUrl1 //private int userComUrl1;
            : ImageView
    lateinit var userComAcc1 //private String userComAcc1;
            : TextView
    lateinit var userComText1 //private String userComText1;
            : TextView
    lateinit var userComDate1 //private String userComDate1;
            : TextView
    lateinit var userComReplyUrl1 //private int userComReplyUrl1;
            : ImageView
    lateinit var userComLikeUrl1 //private int userComLikeUrl1;
            : ImageView
    lateinit var userComLike1 //private int userComLike1;
            : TextView
    lateinit var postsUrl: ImageView
    lateinit var postsCount: TextView
    lateinit var viewersUrl: ImageView
    lateinit var viewersCount: TextView
    private var likesCount = 0
    lateinit var thisNews: News
    override fun onBackPressed() {
        DataBase.news[thisNews.id] = thisNews
        val intent = Intent(this@NewsDetailActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        accountPhotoUrl = findViewById(R.id.accountPhotoUrl)
        accountName = findViewById(R.id.accountName)
        date = findViewById(R.id.date)
        newsText = findViewById(R.id.newsText)
        postPhotoUrl = findViewById(R.id.postPhotoUrl)
        likesUrl = findViewById(R.id.likesUrl)
        likes = findViewById(R.id.likesCount)
        userLike1 = findViewById(R.id.userLike1)
        userLike2 = findViewById(R.id.userLike2)
        likesDetail = findViewById(R.id.likesDetail)
        showCom = findViewById(R.id.showCom) //private String showCom;
        userComUrl1 = findViewById(R.id.userComUrl1) //private int userComUrl1;
        userComAcc1 = findViewById(R.id.userComAcc1) //private String userComAcc1;
        userComText1 = findViewById(R.id.userComText1) //private String userComText1;
        userComDate1 = findViewById(R.id.userComDate1) //private String userComDate1;
        userComReplyUrl1 = findViewById(R.id.userComReplyUrl1) //private int userComReplyUrl1;
        userComLikeUrl1 = findViewById(R.id.userComLikeUrl1) //private int userComLikeUrl1;
        userComLike1 = findViewById(R.id.userComLike1) //private int userComLike1;
        postsUrl = findViewById(R.id.postsUrl)
        postsCount = findViewById(R.id.postsCount)
        viewersUrl = findViewById(R.id.viewersUrl)
        viewersCount = findViewById(R.id.viewersCount)
        val news = intent.getParcelableExtra<Parcelable>("news") as News
        thisNews = news
        likesCount = news.likesCount
        if (news.liked == 1) {
            Glide.with(likesUrl.context)
                    .load(R.drawable.likeblue)
                    .into(likesUrl)
            likes.setTextColor(Color.parseColor("#006ba8"))
        } else {
            Glide.with(likesUrl.context)
                    .load(R.drawable.likemin)
                    .into(likesUrl)
            likes.setTextColor(Color.parseColor("#979899"))
        }
        Glide.with(accountPhotoUrl.context)
                .load(news.accountPhotoUrl)
                .into(accountPhotoUrl)
        accountName.setText(news.accountName)
        date.setText(news.date)
        newsText.setText(news.newsText)
        Glide.with(postPhotoUrl.context)
                .load(news.postPhotoUrl)
                .into(postPhotoUrl)
        likes.setText(Integer.toString(news.likesCount))
        Glide.with(userLike1.context)
                .load(news.userLike1)
                .into(userLike1)
        Glide.with(userLike2.context)
                .load(news.userLike2)
                .into(userLike2)
        likesDetail.setText(news.likesDetail)
        showCom.setText(news.showCom)
        Glide.with(userComUrl1.context)
                .load(news.userComUrl1)
                .into(userComUrl1)
        userComAcc1.setText(news.userComAcc1)
        userComText1.setText(news.userComText1)
        userComDate1.setText(news.userComText1)
        Glide.with(userComReplyUrl1.context)
                .load(news.userComReplyUrl1)
                .into(userComReplyUrl1)
        Glide.with(userComLikeUrl1.context)
                .load(news.userComLikeUrl1)
                .into(userComLikeUrl1)
        userComLike1.setText(Integer.toString(news.userComLike1))
        Glide.with(postsUrl.context)
                .load(news.postsUrl)
                .into(postsUrl)
        Glide.with(postsUrl.context)
                .load(news.postsUrl)
                .into(postsUrl)
        postsCount.setText(news.postsCount.toString())
        Glide.with(viewersUrl.context)
                .load(news.viewersUrl)
                .into(viewersUrl)
        viewersCount.setText(news.viewersCount.toString())
        likesUrl.setOnClickListener({ v ->
            if (news.liked == 1) {
                news.liked = 0
                news.likesCount = news.likesCount - 1
                Glide.with(likesUrl.context)
                        .load(R.drawable.likemin)
                        .into(likesUrl)
                likes.setText(Integer.toString(news.likesCount))
                likes.setTextColor(Color.parseColor("#979899"))
                val toast = Toast.makeText(v.context,
                        "Like removed!",
                        Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                thisNews = news
            } else {
                news.liked = 1
                news.likesCount = news.likesCount + 1
                Glide.with(likesUrl.getContext())
                        .load(R.drawable.likebluemin)
                        .into(likesUrl)
                likes.setText(Integer.toString(news.likesCount))
                likes.setTextColor(Color.parseColor("#006ba8"))
                val toast = Toast.makeText(v.context,
                        "Liked!",
                        Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                thisNews = news
            }
        })
    }
}