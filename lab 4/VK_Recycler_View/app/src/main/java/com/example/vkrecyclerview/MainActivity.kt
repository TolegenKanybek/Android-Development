package com.example.vkrecyclerview

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.HorizontalScrollView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vkrecyclerview.MainActivity
import com.example.vkrecyclerview.NewsListAdapter.ItemClickListener

class MainActivity : AppCompatActivity() {
    lateinit var image1: ImageView
    lateinit var image2: ImageView
    lateinit var image3: ImageView
    lateinit var image4: ImageView
    lateinit var image5: ImageView
    lateinit var image6: ImageView
    lateinit var image7: ImageView
    lateinit var image8: ImageView
    lateinit var image9: ImageView
    lateinit var image10: ImageView
    lateinit var image11: ImageView
    lateinit var image12: ImageView
    lateinit var image13: ImageView
    lateinit var image14: ImageView
    lateinit var image15: ImageView
    lateinit var image16: ImageView
    lateinit var image17: ImageView
    lateinit var image18: ImageView

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsListAdapter
    lateinit var listener: ItemClickListener
    private val KEY_RECYCLER_STATE = "recycler_state"
    lateinit var horizontalScrollView: HorizontalScrollView
    override fun onBackPressed() {
        finish()
    }

    override fun onPause() {
        super.onPause()
        // save RecyclerView state
        mBundleRecyclerViewState = Bundle()
        val listState = recyclerView.layoutManager!!.onSaveInstanceState()
        mBundleRecyclerViewState!!.putParcelable(KEY_RECYCLER_STATE, listState)
    }

    override fun onResume() {
        super.onResume()
        // restore RecyclerView state
        if (mBundleRecyclerViewState != null) {
            val listState = mBundleRecyclerViewState!!.getParcelable<Parcelable>(KEY_RECYCLER_STATE)
            recyclerView.layoutManager!!.onRestoreInstanceState(listState)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)
        image4 = findViewById(R.id.image4)
        image5 = findViewById(R.id.image5)
        image6 = findViewById(R.id.imageView6)
        image7 = findViewById(R.id.image7)
        image8 = findViewById(R.id.image8)
        image9 = findViewById(R.id.image9)
        image10 = findViewById(R.id.image10)
        image11 = findViewById(R.id.image11)
        image12 = findViewById(R.id.image12)
        image13 = findViewById(R.id.image13)
        image14 = findViewById(R.id.image14)
        image15 = findViewById(R.id.image15)
        image16 = findViewById(R.id.image16)
        image17 = findViewById(R.id.image17)
        image18 = findViewById(R.id.image18)
        Glide.with(image1.getContext())
                .load(R.drawable.three)
                .into(image1)
        Glide.with(image2.getContext())
                .load(R.drawable.down)
                .into(image2)
        Glide.with(image3.getContext())
                .load(R.drawable.lupa)
                .into(image3)
        Glide.with(image4.getContext())
                .load(R.drawable.cam)
                .into(image4)
        Glide.with(image5.getContext())
                .load(R.drawable.grdiv)
                .into(image5)
        Glide.with(image6.getContext())
                .load(R.drawable.pen)
                .into(image6)
        Glide.with(image7.getContext())
                .load(R.drawable.icon2)
                .into(image7)
        Glide.with(image8.getContext())
                .load(R.drawable.icon4)
                .into(image8)
        Glide.with(image9.getContext())
                .load(R.drawable.icon1)
                .into(image9)
        Glide.with(image10.getContext())
                .load(R.drawable.icon3)
                .into(image10)
        Glide.with(image11.getContext())
                .load(R.drawable.icon5)
                .into(image11)
        Glide.with(image12.getContext())
                .load(R.drawable.icon6)
                .into(image12)
        Glide.with(image13.getContext())
                .load(R.drawable.icon7)
                .into(image13)
        Glide.with(image14.getContext())
                .load(R.drawable.icon8)
                .into(image14)
        Glide.with(image15.getContext())
                .load(R.drawable.kotmin)
                .into(image15)
        Glide.with(image16.getContext())
                .load(R.drawable.news3)
                .into(image16)
        Glide.with(image17.getContext())
                .load(R.drawable.icon9)
                .into(image17)
        Glide.with(image18.getContext())
                .load(R.drawable.news5)
                .into(image18)
        listener = object : ItemClickListener {
            override fun itemClick(position: Int, item: News?) {
                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                intent.putExtra("news", item)
                startActivity(intent)
            }
        }
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        horizontalScrollView = findViewById(R.id.horizontalScrollView)
        adapter = NewsListAdapter(newsGenerator(), listener)
        recyclerView.setAdapter(adapter)
    }

    private fun newsGenerator(): List<News> {
        return DataBase.news
    }

    companion object {
        private var mBundleRecyclerViewState: Bundle? = null
    }
}