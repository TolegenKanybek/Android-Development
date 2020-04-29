package com.example.vkrecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class SecondFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var adapter: FavouriteNewsListAdapter? = null
    private var listener: FavouriteNewsListAdapter.ItemClickListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listener = object : FavouriteNewsListAdapter.ItemClickListener {
            override fun itemClick(position: Int, item: News?) {
                val intent = Intent(activity, NewsDetailActivity::class.java)
                intent.putExtra("news", item)
                startActivity(intent)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.second_fragment, container, false)
        recyclerView = view.findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        adapter = FavouriteNewsListAdapter(newsGenerator(), listener)
        recyclerView!!.adapter = adapter
        return view
    }

    private fun newsGenerator(): List<News> {
        return favoriteItems
    }

    companion object {
        var favoriteItems: List<News> = ArrayList()
        const val TAG = "SecondFragmentTag"
    }
}