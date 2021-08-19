package com.cursoandroid.aprendaingles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.cursoandroid.aprendaingles.fragments.BichosFragment
import com.cursoandroid.aprendaingles.fragments.NumerosFragment
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class MainActivity : AppCompatActivity() {

    private lateinit var smartTabLayout: SmartTabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.elevation ?: 0

        smartTabLayout = findViewById(R.id.smartTabLayout)
        viewPager = findViewById(R.id.viewPager)

        val adapter = FragmentPagerItemAdapter(
            supportFragmentManager, FragmentPagerItems.with(this)
                .add("Bichos", BichosFragment::class.java)
                .add("Números", NumerosFragment::class.java)
                .create()
        )

        viewPager.adapter = adapter
        smartTabLayout.setViewPager(viewPager)

    }
}