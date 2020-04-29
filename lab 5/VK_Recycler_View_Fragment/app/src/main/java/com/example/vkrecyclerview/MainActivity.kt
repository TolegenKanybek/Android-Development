package com.example.vkrecyclerview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : FragmentActivity() {
    private var firstFragment: FirstFragment? = null
    private var secondFragment: SecondFragment? = null
    lateinit private var fragmentManager: FragmentManager
    private var transaction: FragmentTransaction? = null
    private var pager: CustomViewPager? = null
    private var pagerAdapter: PagerAdapter? = null
    private val list: MutableList<Fragment> = ArrayList()
    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        transaction = fragmentManager.beginTransaction()
        transaction!!.replace(R.id.container, firstFragment!!, FirstFragment.TAG)
        transaction!!.commit()
        val bottomNav: BottomNavigationView = findViewById(R.id.nav_menu)
        bottomNav.setOnNavigationItemSelectedListener(navListener)
        list.add(FirstFragment())
        list.add(SecondFragment())
        pager = findViewById<View>(R.id.container) as CustomViewPager
        pager!!.setPagingEnabled(false)
        pagerAdapter = SlidePagerAdapter(supportFragmentManager, list)
        pager!!.adapter = pagerAdapter
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        pagerAdapter!!.notifyDataSetChanged()
        when (menuItem.itemId) {
            R.id.nav_home -> pager!!.setCurrentItem(0, false)
            R.id.nav_favorite -> pager!!.setCurrentItem(1, false)
        }
        false
    }

    companion object {
        private const val TAG = "MyActivity"
    }
}