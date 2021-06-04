package com.poit.watchapp_kotlin.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.poit.watchapp_kotlin.R
import com.poit.watchapp_kotlin.databinding.FragmentMapBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var mMap: GoogleMap
    private var mapReady = false
    private var _binding: FragmentMapBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentMapBinding.inflate(inflater, container, false)

        val root: View = binding.root

        val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment

        dashboardViewModel.itemList.observe(viewLifecycleOwner, Observer { mutableItemList ->
            //val items = mutableItemList
            mapFragment.getMapAsync(OnMapReadyCallback {
                mMap = it
                for(item in mutableItemList) {
                    mMap.addMarker(
                        MarkerOptions()
                            .position(LatLng(item.latitude!!, item.longitude!!))
                            .title(item.name)
                    )
                }
            })
        })
        //mapFragment.getMapAsync(this)
        /*
        mapFragment.getMapAsync {
            googleMap -> mMap = googleMap
            mapReady = true
            updateMap()
        }
        */
        return root
    }

    private fun updateMap() {
        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}