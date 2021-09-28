package com.example.carcamping.ui.home

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.utils.ViewState
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.carcamping.R
import com.example.carcamping.base.BaseFragment
import com.example.carcamping.databinding.MapFragmentBinding
import com.example.carcamping.utils.GpsTracker
import com.example.carcamping.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MapFragment : BaseFragment<MapFragmentBinding>(R.layout.map_fragment) {

    //private lateinit var mapView: MapView

    private lateinit var gpsTracker: GpsTracker

    private val campingItemList = mutableSetOf<MapPOIItem>()

    private val homeViewModel by sharedViewModel<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        initViewModel()
    }

    private fun initViewModel() {

        homeViewModel.viewStateLiveData.observe(requireActivity()){ viewState ->
            (viewState as? HomeViewModel.HomeViewState)?.let { onChangedHomeViewState(it)}
        }
    }

    private fun onChangedHomeViewState(viewState: ViewState) {
        when (viewState) {
            is HomeViewModel.HomeViewState.GetGoCampingLocationList -> {
                GlobalScope.launch(Dispatchers.IO) {
                    viewState.itemList.forEach { item ->
                        val mapPOIItem = MapPOIItem().apply {
                            itemName = item.facltNm
                            mapPoint = MapPoint.mapPointWithGeoCoord(item.mapY, item.mapX)
                            markerType = MapPOIItem.MarkerType.RedPin
                        }
                        campingItemList.add(mapPOIItem)
                    }

                    withContext(Dispatchers.Main) {
                        binding.containerMap.addPOIItems(campingItemList.toTypedArray())
                    }
                }
            }
        }
    }

    private fun loadMapView() {

        gpsTracker = GpsTracker(requireActivity())

        val currentMapPoint = MapPoint.mapPointWithGeoCoord(
            gpsTracker.getCurrentLatitude(),
            gpsTracker.getCurrentLongitude()
        )

        getItemsAroundCurrent(currentMapPoint)

        val mapPOIItem = MapPOIItem().apply {
            itemName = "searchItem"
            mapPoint = currentMapPoint
        }

        with(binding.containerMap) {
            addPOIItem(mapPOIItem)
            setZoomLevel(8, false)
            setMapCenterPoint(currentMapPoint, false)
        }

    }

    private fun getItemsAroundCurrent(mapPoint: MapPoint) {
        homeViewModel.getGoCampingLocationList(
            latitude = mapPoint.mapPointGeoCoord.latitude,
            longitude = mapPoint.mapPointGeoCoord.longitude,
            radius = 20000
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            999 -> {
                loadMapView()
            }

            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }

    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ), 999
            )
        } else {
            loadMapView()
        }

    }

}
