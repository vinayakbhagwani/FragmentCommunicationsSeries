package com.demo.fragmentdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FirstFragmentListener, SecondFragmentListener {

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

    override fun onInputFirstSent(input: String) {
        fragmentSecond.updateEditText(input)
    }

    override fun onInputSecondSent(input: String) {
        fragmentFirst.updateEditText(input)
    }
}