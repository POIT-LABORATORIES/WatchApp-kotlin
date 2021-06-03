package com.poit.watchapp_kotlin.dao

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.HashMap

class FirestoreDatabase {
    private val db = Firebase.firestore

    public fun getCollection(collectionName: String) : Task<QuerySnapshot> {
        return db.collection("watches").get()
    }
}