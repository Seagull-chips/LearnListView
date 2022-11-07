package com.seagull.listview

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_layout)
//        val listView = findViewById<ListView>(R.id.listView)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //1.ListView最简单的使用方式：使用安卓提供的布局文件
        //adapter适配器数据源-> UI
        //ArrayAdapter Context对象：Activity对象 resource: Item的布局文件 object：传进来的数据集合
//        2. ListView 自定义布局文件
//        listView.adapter =
//            ListViewAdapter(this, R.layout.itemlayout, creatLifeFataList())
        //添加点击事件
//        listView.setOnItemClickListener { patrent, view, position, id ->
//            Toast.makeText(this, position.toString(), Toast.LENGTH_SHORT).show()
//        }
//        3. RecyclerView的使用方式
        //layoutManager：决定item在RecyclerView中按照什么布局进行排列
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter(creatLifeFataList())
        /*RecyclerView优点：
             1.支持多种样式的布局
             2.强制使用ViewHolder，提升性能
             3.将getView拆分为了creat、bind 逻辑更清晰
             4.支持更灵活的点击事件设置
         */

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