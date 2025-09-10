package com.example.simplecounter

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.button)
        var counter = 0
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)
        val img = findViewById<ImageView>(R.id.stateImage)
        button.setOnClickListener {
            //Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            val textView = findViewById<TextView>(R.id.textView)
            counter++
            textView.text = counter.toString()
            img.setImageResource(if (counter % 2 == 0) R.drawable.dog2 else R.drawable.dog3)
            if (counter >= 100){
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text="Add 2"
                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }
                    upgradeButton.visibility = View.INVISIBLE
                }
            }

        }



    }


}