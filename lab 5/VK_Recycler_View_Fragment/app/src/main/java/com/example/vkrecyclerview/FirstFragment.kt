package com.example.vkrecyclerview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vkrecyclerview.NewsListAdapter
import java.util.*

class FirstFragment : Fragment() {
    var items: List<News> = ArrayList()
    private var recyclerView: RecyclerView? = null
    private var adapter: NewsListAdapter? = null
    private var listener: NewsListAdapter.ItemClickListener? = null
    private val KEY_RECYCLER_STATE = "recycler_state"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val image1 = getView()!!.findViewById<ImageView>(R.id.image1)
        val image2 = getView()!!.findViewById<ImageView>(R.id.image2)
        val image3 = getView()!!.findViewById<ImageView>(R.id.image3)
        val image4 = getView()!!.findViewById<ImageView>(R.id.image4)
        val image5 = getView()!!.findViewById<ImageView>(R.id.image5)
        val image6 = getView()!!.findViewById<ImageView>(R.id.imageView6)
        val image7 = getView()!!.findViewById<ImageView>(R.id.image7)
        val image8 = getView()!!.findViewById<ImageView>(R.id.image8)
        val image9 = getView()!!.findViewById<ImageView>(R.id.image9)
        val image10 = getView()!!.findViewById<ImageView>(R.id.image10)
        val image11 = getView()!!.findViewById<ImageView>(R.id.image11)
        val image12 = getView()!!.findViewById<ImageView>(R.id.image12)
        val image13 = getView()!!.findViewById<ImageView>(R.id.image13)
        val image14 = getView()!!.findViewById<ImageView>(R.id.image14)
        val image15 = getView()!!.findViewById<ImageView>(R.id.image15)
        val image16 = getView()!!.findViewById<ImageView>(R.id.image16)
        val image17 = getView()!!.findViewById<ImageView>(R.id.image17)
        val image18 = getView()!!.findViewById<ImageView>(R.id.image18)
        Glide.with(image1.context)
                .load(R.drawable.three)
                .into(image1)
        Glide.with(image2.context)
                .load(R.drawable.down)
                .into(image2)
        Glide.with(image3.context)
                .load(R.drawable.lupa)
                .into(image3)
        Glide.with(image4.context)
                .load(R.drawable.cam)
                .into(image4)
        Glide.with(image5.context)
                .load(R.drawable.grdiv)
                .into(image5)
        Glide.with(image6.context)
                .load(R.drawable.pen)
                .into(image6)
        Glide.with(image7.context)
                .load(R.drawable.icon2)
                .into(image7)
        Glide.with(image8.context)
                .load(R.drawable.icon4)
                .into(image8)
        Glide.with(image9.context)
                .load(R.drawable.icon1)
                .into(image9)
        Glide.with(image10.context)
                .load(R.drawable.icon3)
                .into(image10)
        Glide.with(image11.context)
                .load(R.drawable.icon5)
                .into(image11)
        Glide.with(image12.context)
                .load(R.drawable.icon6)
                .into(image12)
        Glide.with(image13.context)
                .load(R.drawable.icon7)
                .into(image13)
        Glide.with(image14.context)
                .load(R.drawable.icon8)
                .into(image14)
        Glide.with(image15.context)
                .load(R.drawable.kotmin)
                .into(image15)
        Glide.with(image16.context)
                .load(R.drawable.news3)
                .into(image16)
        Glide.with(image17.context)
                .load(R.drawable.icon9)
                .into(image17)
        Glide.with(image18.context)
                .load(R.drawable.news5)
                .into(image18)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listener = NewsListAdapter.ItemClickListener { position, item ->
            val intent = Intent(activity, NewsDetailActivity::class.java)
            intent.putExtra("news", item)
            startActivity(intent)
            (activity as Activity?)!!.overridePendingTransition(0, 0)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.first_fragment, container, false)
        recyclerView = view.findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        adapter = NewsListAdapter(newsGenerator(), listener)
        recyclerView!!.adapter = adapter
        return view
    }

    override fun onResume() {
        super.onResume()
        if (mBundleRecyclerViewState != null) {
            val listState = mBundleRecyclerViewState!!.getParcelable<Parcelable>(KEY_RECYCLER_STATE)
            recyclerView!!.layoutManager!!.onRestoreInstanceState(listState)
        }
    }

    override fun onPause() {
        super.onPause()
        mBundleRecyclerViewState = Bundle()
        val listState = recyclerView!!.layoutManager!!.onSaveInstanceState()
        mBundleRecyclerViewState!!.putParcelable(KEY_RECYCLER_STATE, listState)
    }

    fun newsGenerator(): List<News> {
        items = DataBase.news
        return items
    }

    companion object {
        const val TAG = "FirstFragmentTag"
        private var mBundleRecyclerViewState: Bundle? = null
    }
}