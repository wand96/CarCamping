package com.example.carcamping.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.carcamping.databinding.ActivityHomeBinding
import com.example.carcamping.ui.api.GoCampingRetrofit
import com.example.carcamping.ui.data.repo.GoCampingRepositoryImpl
import com.example.carcamping.ui.data.source.remote.GoCampingRemoteDataSourceImpl
import com.example.carcamping.ui.viewmodel.HomeViewModel
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.IllegalArgumentException

class HomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    private val homeViewModel by lazy {

        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                    return HomeViewModel(
                        GoCampingRepositoryImpl(
                            GoCampingRemoteDataSourceImpl(
                                GoCampingRetrofit.create()
                            )
                        )
                    ) as T
                } else throw IllegalArgumentException()
            }
        }).get(HomeViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        initUi()

        homeViewModel.getGoCampingBasedList()
    }

    private fun initUi() {
        val list = listOf(MapFragment(), BookMarkFragment(), SnapFragment())

        val pagerAdapter = FragmentPagerAdapter(list, this)
        val titles = listOf("Map", "BookMark", "Snap")

        with(binding) {
            viewPager.adapter = pagerAdapter

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
    override fun createFragment(position: Int) = fragmentList.get(position)

}