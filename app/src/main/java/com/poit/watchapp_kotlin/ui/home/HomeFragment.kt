package com.poit.watchapp_kotlin.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.poit.watchapp_kotlin.adapters.ItemsAdapter
import com.poit.watchapp_kotlin.databinding.FragmentHomeBinding
import com.poit.watchapp_kotlin.models.Item

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listView: ListView = binding.itemList

        homeViewModel.itemList.observe(viewLifecycleOwner, Observer {
            var items = it
            val activity = activity as Context
            //var arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, items);
            var arrayAdapter = ItemsAdapter(items, activity);
            //var arrayAdapter: ArrayAdapter<Item> = ArrayAdapter<Item>(activity, android.R.layout.simple_list_item_1, items);
            listView.adapter = arrayAdapter;
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}