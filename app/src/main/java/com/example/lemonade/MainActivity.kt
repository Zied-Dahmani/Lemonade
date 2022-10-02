package com.example.lemonade

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var image: ImageView
    lateinit var text: TextView
    var state = State.tree
    var nb = (1..5).random()
    var nbClicks = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image = findViewById(R.id.imageView)
        text = findViewById(R.id.text)

        image.setOnClickListener{
            when (state) {
                State.tree -> {
                    state = State.lemon
                    image.setImageResource(R.drawable.lemon)
                    text.text = "Click to juice the lemon!"
                }
                State.lemon-> {
                    if(nbClicks<nb)
                    {
                        nbClicks++
                        val snack = Snackbar.make(it,"Squeeze count: $nbClicks, keep squeezing!",Snackbar.LENGTH_LONG)
                        snack.show()
                    }
                    else
                    {
                        state = State.lemonade
                        image.setImageResource(R.drawable.lemonade)
                        text.text = "Click to drink your lemonade!"
                    }

                }
                State.lemonade -> {
                    state = State.emptyGlass
                    image.setImageResource(R.drawable.glass)
                    text.text = "Click to start again!"
                    nb = (1..5).random()
                    nbClicks = 0
                }
                else -> {
                    state = State.tree
                    image.setImageResource(R.drawable.tree)
                    text.text = "Click to select a lemon!"
                }
            }
        }
    }



}