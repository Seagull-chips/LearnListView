package com.seagull.listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val data: List<LifeData>) :
    RecyclerView.Adapter<RecyclerViewHolder>() {
    //数据源 -> UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        //创建ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false)
        //添加点击事件
        val holder = RecyclerViewHolder(view)
        holder.itemView.setOnClickListener {
            Toast.makeText(
                parent.context,
                data[holder.bindingAdapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
        }
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        //更新ViewHolder中的样式
        val lifeData = data[position]
        holder.image.setImageResource(lifeData.imageId)
        holder.text.text = lifeData.name
    }

    override fun getItemCount(): Int {
        //item 的个数
        return data.size
    }
}

class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image = itemView.findViewById<ImageView>(R.id.item_image)
    val text = itemView.findViewById<TextView>(R.id.item_text)
}