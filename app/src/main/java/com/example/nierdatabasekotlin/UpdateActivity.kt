package com.example.nierdatabasekotlin

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import io.paperdb.Paper
import kotlin.system.exitProcess

class UpdateActivity : AppCompatActivity() {

    private lateinit var dbClass : NierDBScheme
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        val updateEntry : Button = findViewById(R.id.updateEntry)
        val deleteEntry : Button = findViewById(R.id.deleteEntry)
        val name : EditText = findViewById(R.id.name_edit)
        val desc : EditText = findViewById(R.id.desc_edit)

        val bundle: Bundle? = intent.extras
        val charName = bundle!!.getString("name")
        val descChar = bundle.getString("desc")

        Paper.init(this)
        name.setText(charName)
        desc.setText(descChar)
        dbClass = NierDBScheme()
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.dark_brown)))

        updateEntry.setOnClickListener{
            val char = Characters(charName.toString(), descChar.toString())
            dbClass.deleteChar(char)
            val characters = Characters(name.text.toString(), desc.text.toString())
            dbClass.addChar(characters)
            Runtime.getRuntime().exit(0)
        }

        deleteEntry.setOnClickListener {
            val characters = Characters(charName.toString(), descChar.toString())
                dbClass.deleteChar(characters)
            Runtime.getRuntime().exit(0)
        }
    }
}
