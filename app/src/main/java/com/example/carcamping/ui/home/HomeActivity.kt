package com.example.carcamping.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.carcamping.R
import com.example.carcamping.base.BaseActivity
import com.example.carcamping.databinding.ActivityHomeBinding
import com.example.carcamping.viewmodel.HomeViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val homeViewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUi()

    }

    private fun initUi() {
        val list = listOf(MapFragment(), BookMarkFragment(), SnapFragment())

        val pagerAdapter = FragmentPagerAdapter(list, this)
        val titles = listOf("Map", "BookMark", "Snap")

        with(binding) {
            viewPager.adapter = pagerAdapter
            viewPager.offscreenPageLimit = 4
            viewPager.isUserInputEnabled = false

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = titles[position]
            }.attach()
        }
    }
}

class FragmentPagerAdapter(
    private val fragmentList: List<Fragment>,
    fragmentActivity: FragmentActivity
) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = fragmentList.size
    override fun createFragment(position: Int) = fragmentList[position]

}