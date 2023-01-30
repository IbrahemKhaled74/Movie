package com.example.movie.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.movie.R
import com.example.movie.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPager : Fragment() {
    lateinit var bind:FragmentViewPagerBinding
    lateinit var viewPagerAdaptor: ViewPagerAdaptor
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val items= listOf(
            ViewPagerItem(
            R.drawable.intro,
            R.string.welcome_to_fliqs,
            R.string.welcome_text,
        ),
            ViewPagerItem(
            R.drawable.intro,
            R.string.title2,
            R.string.subtitle2,
        ),
            ViewPagerItem(
            R.drawable.intro,
            R.string.welcome_to_fliqs,
            R.string.welcome_text,
        ),
        )
         bind=DataBindingUtil.inflate(inflater,
            R.layout.fragment_view_pager, container, false)

        viewPagerAdaptor= ViewPagerAdaptor(items)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind.viewPager.adapter=viewPagerAdaptor

        TabLayoutMediator(bind.introTabLayout,bind.viewPager){tab,pos->

        }.attach()

    }

}