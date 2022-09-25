package com.seagull.listview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter(
    private val activity: Activity,
    private val resourceId: Int,
    private val data: List<LifeData>
) : ArrayAdapter<LifeData>(activity, resourceId, data) {

    //非常重要
    //position：位置 convertView： View parent

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //给出position位置的View长什么样
        val view = LayoutInflater.from(activity).inflate(resourceId, parent, false)
        val image = view.findViewById<ImageView>(R.id.item_image)
        val text = view.findViewById<TextView>(R.id.item_text)

        //更新image和Text
        val lifeData = data[position]
        image.setImageResource(lifeData.imageId)
        text.text = lifeData.name
        return view
    }
}