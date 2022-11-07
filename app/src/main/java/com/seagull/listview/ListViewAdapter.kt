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
        //convertView:ListView 优化 convertView：可以被服用的View

        //给出position位置的View长什么样
        //优化1.将convertView利用起来，如果convertView不为Null则直接使用，否则新建一个View
        val view: View
        val viewHolder: ListViewHolder
        if (convertView == null) {
            //对应着onCreateViewHolder
            view = LayoutInflater.from(activity).inflate(resourceId, parent, false)
            viewHolder = ListViewHolder(view)
            //通过setTag可以将ViewHolder保存在View中
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ListViewHolder
        }

        //优化2 findViewById：二叉树查找
        //ViewHolder: 把View保存起来保存到这个中
//        val image = view.findViewById<ImageView>(R.id.item_image)
//        val text = view.findViewById<TextView>(R.id.item_text)

        //更新image和Text
        //对应onBindViewHolder
        val lifeData = data[position]
        viewHolder.image.setImageResource(lifeData.imageId)
        viewHolder.text.text = lifeData.name
        return view
    }
}

class ListViewHolder(view: View) {
    val image = view.findViewById<ImageView>(R.id.item_image)
    val text = view.findViewById<TextView>(R.id.item_text)
}