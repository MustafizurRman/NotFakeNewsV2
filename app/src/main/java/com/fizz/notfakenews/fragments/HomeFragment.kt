package com.fizz.notfakenews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fizz.notfakenews.adapter.ViewPagerAdapter
import com.fizz.notfakenews.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPagerAdapter = ViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        val tabLayout = binding.tabMode
        val viewPager2 = binding.viewPager
        viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager2){
                tab,position ->
            when(position){
                0 -> tab.text="Home"
                1 -> tab.text="BBC"
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}