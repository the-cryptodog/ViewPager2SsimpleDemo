package com.example.viewpager2

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_scale.*
import kotlin.random.Random


class ScaleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scale, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        scaleImageView.setOnClickListener {
            val factor = if(Random.nextBoolean())0.1f else -0.1f
            ObjectAnimator.ofFloat(it,"scaleX",it.scaleX+factor).start()
            ObjectAnimator.ofFloat(it,"scaleY",it.scaleY+factor).start()
        }
    }

}