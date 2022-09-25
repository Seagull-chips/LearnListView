package com.seagull.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview_layout)
        val listView = findViewById<ListView>(R.id.listView)
        //1.ListView最简单的使用方式：使用安卓提供的布局文件
        //adapter适配器数据源-> UI
        //ArrayAdapter Context对象：Activity对象 resource: Item的布局文件 object：传进来的数据集合
        listView.adapter =
            ListViewAdapter(this, R.layout.itemlayout,creatLifeFataList())
        //listView自定义布局文件

    }

    private fun creatLifeFataList(): List<LifeData> {
        val data = ArrayList<LifeData>()
        repeat(4) {
            data.add(LifeData(R.drawable.facebook, "facebook"))
            data.add(LifeData(R.drawable.instagram, "instagram"))
            data.add(LifeData(R.drawable.tiktok, "tiktok"))
            data.add(LifeData(R.drawable.twitter, "twitter"))
            data.add(LifeData(R.drawable.wechat, "wechat"))
            data.add(LifeData(R.drawable.youtube, "youtube"))
        }
        return data
    }
}

data class LifeData(val imageId: Int, val name: String)