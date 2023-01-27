package com.example.nierdatabasekotlin

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {
    private lateinit var addNewEntry : FloatingActionButton
    private lateinit var recyclerView : RecyclerView
    private lateinit var listChars: ArrayList<Characters>
    private lateinit var dbClass : NierDBScheme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addNewEntry = findViewById(R.id.addNewEntry)
        recyclerView = findViewById(R.id.recyclerView)
        Paper.init(this);
        recyclerView.layoutManager = LinearLayoutManager(this)

        listChars = ArrayList()

        dbClass = NierDBScheme()
        var charAdapter = Adapter(dbClass.getCharacters())
        recyclerView.adapter = charAdapter
        charAdapter.setOnItemClickListener(object : Adapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, UpdateActivity::class.java)
                intent.putExtra("name", dbClass.getCharacters()[position].nameChar)
                intent.putExtra("desc", dbClass.getCharacters()[position].descChar)
                startActivity(intent)
            }
        })
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.dark_brown)))
        addNewEntry.setOnClickListener {
            val intent = Intent(this, AddNewEntry::class.java)
            startActivity(intent)
        }
    }
}