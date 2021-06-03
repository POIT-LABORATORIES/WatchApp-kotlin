package com.poit.watchapp_kotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.poit.watchapp_kotlin.R
import com.poit.watchapp_kotlin.models.Item
import com.squareup.picasso.Picasso

class ItemsAdapter(items: MutableList<Item>, ctx: Context) :
    ArrayAdapter<Item>(ctx, R.layout.list_item, items) {

    // View holder is used to prevent findViewById calls.
    private class ListItemViewHolder {
        var image: ImageView? = null
        var name: TextView? = null
        var style: TextView? = null
        var color: TextView? = null
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view

        val viewHolder: ListItemViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.list_item, viewGroup, false)

            viewHolder = ListItemViewHolder()
            viewHolder.name = view!!.findViewById<View>(R.id.item_name) as TextView
            viewHolder.style = view.findViewById<View>(R.id.item_style) as TextView
            viewHolder.color = view.findViewById<View>(R.id.item_color) as TextView
            viewHolder.image = view.findViewById<View>(R.id.item_image) as ImageView
        } else {
            //no need to call findViewById, can use existing ones from saved view holder
            viewHolder = view.tag as ListItemViewHolder
        }

        val item = getItem(i)
        viewHolder.name!!.text = item!!.name
        viewHolder.style!!.text = item.style
        viewHolder.color!!.text = item.caseColor
        Picasso.get().load(item.avatarUrl).into(viewHolder.image);

        view.tag = viewHolder

        return view
    }

}