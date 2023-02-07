package com.example.movie.onboarding

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.movie.Constants
import com.example.movie.R
import com.example.movie.databinding.FragmentViewPagerBinding
import com.example.movie.databinding.ViewPagerItemBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPager : Fragment() {
    lateinit var bind:FragmentViewPagerBinding
    lateinit var itemBind:ViewPagerItemBinding
    lateinit var viewPagerAdaptor: ViewPagerAdaptor
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val items= listOf(
            ViewPagerItem(
            R.string.next,
            R.string.welcome_to_fliqs,
            R.string.welcome_text,
        ),
            ViewPagerItem(
            R.string.next,
            R.string.title2,
            R.string.subtitle2,
        ),
            ViewPagerItem(
            R.string.getStarted,
            R.string.welcome_to_fliqs,
            R.string.welcome_text,
        ),
        )
         bind=DataBindingUtil.inflate(inflater,
            R.layout.fragment_view_pager, container, false)

         itemBind=DataBindingUtil.inflate(inflater,
            R.layout.view_pager_item, container, false)

        viewPagerAdaptor= ViewPagerAdaptor(items)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind.viewPager.adapter=viewPagerAdaptor
        viewPagerAdaptor.onClickListener=object :ViewPagerAdaptor.OnButtonClickListener{
            override fun onClick( position: Int) {
                when(position){
                    0->{
                        bind.viewPager.currentItem=1
                    }
                    1->{
                        bind.viewPager.currentItem=2
                    }
                    2->{
                        findNavController().navigate(R.id.action_viewPager_to_login)
                        onBoardingFinished()
                    }

                }
            }

        }


        TabLayoutMediator(bind.introTabLayout,bind.viewPager){tab,pos->

        }.attach()


    }
    private fun onBoardingFinished(){
        val sharedPerf=requireActivity().getSharedPreferences(Constants.onBoarding,Context.MODE_PRIVATE)
        val editor=sharedPerf.edit()
        editor.putBoolean(Constants.finish,true)
        editor.apply()

    }


}