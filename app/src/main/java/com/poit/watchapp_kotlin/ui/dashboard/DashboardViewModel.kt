package com.poit.watchapp_kotlin.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObject
import com.poit.watchapp_kotlin.dao.FirestoreDatabase
import com.poit.watchapp_kotlin.models.Item

class DashboardViewModel : ViewModel() {

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
        value = docs
    }
    val itemList: LiveData<MutableList<Item>> = _itemList
}