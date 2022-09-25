package com.seagull.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
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
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, creatStringList())
    }

    private fun creatStringList(): List<String> {
        val data = ArrayList<String>()

        for (i in 0..100) {
            data.add(i.toString())
        }
        return data
    }
}