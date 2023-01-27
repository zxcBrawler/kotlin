package com.example.nierdatabasekotlin

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import io.paperdb.Paper
import kotlin.system.exitProcess

class AddNewEntry : AppCompatActivity() {

    private lateinit var characters : Characters
    private lateinit var dbClass : NierDBScheme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_entry)
        val add : Button = findViewById(R.id.addEntry)
        val name : EditText = findViewById(R.id.name)
        val desc : EditText = findViewById(R.id.desc)
        dbClass = NierDBScheme()
        Paper.init(this)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.dark_brown)))

       add.setOnClickListener {
           val characters = Characters(name.text.toString(), desc.text.toString())
           dbClass.addChar(characters)
           finish()
           Runtime.getRuntime().exit(0)
       }
    }
}