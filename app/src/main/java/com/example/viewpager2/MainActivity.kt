package com.example.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.FrameStats
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //匿名內部類別的寫法
        viewPager2.adapter = object : FragmentStateAdapter(this) {
            //告訴viewpager頁面總數
            override fun getItemCount() = 3

            override fun createFragment(position: Int) =
                when (position) {
                    0 -> ScaleFragment()
                    1 -> RotateFragment()
                    else -> TranslateFragment()
                }
        }
        TabLayoutMediator(tabLayout,viewPager2){tab, position ->
            when(position){
                0->tab.text = "縮放"
                1->tab.text = "旋轉"
                else->tab.text = "移動"
            }
        }.attach()
    }
}