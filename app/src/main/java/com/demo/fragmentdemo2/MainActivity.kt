package com.demo.fragmentdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var fragmentFirst: FirstFragment
    lateinit var fragmentSecond: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews() {
        fragmentFirst = FirstFragment()
        fragmentSecond = SecondFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_first,fragmentFirst)
            .replace(R.id.container_second,fragmentSecond)
            .commit()
    }
}