package com.poit.watchapp_kotlin.ui.home

import android.widget.ListView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObject
import com.poit.watchapp_kotlin.dao.FirestoreDatabase
import com.poit.watchapp_kotlin.models.Item

class HomeViewModel : ViewModel() {

    private var _itemList = MutableLiveData<MutableList<String>>().apply {
        val docs: MutableList<String> = ArrayList()
        FirestoreDatabase()
            .getCollection("watches")
            .addOnSuccessListener { result ->
                for (document in result) {
                    val item : Item = document.toObject()
                    docs.add(item.name!!)
                }
                value = docs
            }
            .addOnFailureListener { exception ->
                print("Error getting documents: $exception")
                value = docs
            }
        value = docs
    }
    val itemList: LiveData<MutableList<String>> = _itemList




    /*
    private var _itemList = MutableLiveData<MutableList<Item>>().apply {
        val docs: MutableList<Item> = ArrayList()
        FirestoreDatabase()
            .getCollection("watches")
            .addOnSuccessListener { result ->
                for (document in result) {
                    val item : Item = document.toObject()
                    docs.add(item)
                }
                value = docs
            }
            .addOnFailureListener { exception ->
                print("Error getting documents: $exception")
                value = docs
            }
    }
    val itemList: LiveData<MutableList<Item>> = _itemList
    */




    /*
    private var _itemList = MutableLiveData<MutableList<String>>().apply {
        FirestoreDatabase()
            .getCollection("watches")
            .addOnSuccessListener { result ->
                for (document in result) {
                    print("DOCUMENT: ${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                print("Error getting documents: $exception")
            }

        value = arrayListOf("Melbourne", "Vienna", "Vancouver", "Toronto",
            "Calgary", "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg", "Munich", "New York",
            "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")
    }
    val itemList: LiveData<MutableList<String>> = _itemList
    */
}