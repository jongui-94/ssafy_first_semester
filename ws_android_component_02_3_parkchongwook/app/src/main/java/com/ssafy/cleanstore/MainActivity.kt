package com.ssafy.cleanstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.ssafy.cleanstore.databinding.ActivityMainBinding
import com.ssafy.cleanstore.fragment.MainFragment
import com.ssafy.cleanstore.fragment.StoreFragment
import com.ssafy.cleanstore.stuff.StuffActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun initViews() = with(binding) {

        tabLayoutMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                val selectedFragment = when (tab!!.position) {
                    0 -> MainFragment()
                    1 -> StoreFragment()
                    else -> null
                }
                replaceFragments(selectedFragment!!)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }

    private fun replaceFragments(f: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_main,f)
            .commit()
    }
}