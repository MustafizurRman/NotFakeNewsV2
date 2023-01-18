package com.fizz.notfakenews.adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fizz.notfakenews.fragments.BBCFragment
import com.fizz.notfakenews.fragments.HomeFragment


class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            1 -> BBCFragment()
            else -> HomeFragment()

        }
    }
}