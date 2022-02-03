package com.example.cn333as1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var imageButtonReset: ImageButton
    lateinit var imageButtonCheck: ImageButton
    lateinit var attempShowing: TextView

    var random: Int = nextInt(1, 1000)
    var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        imageButtonCheck = findViewById(R.id.imageButtonCheck)
        imageButtonReset = findViewById(R.id.imageButtonReset)
        attempShowing = findViewById(R.id.attempShowing)

        imageButtonCheck.setOnClickListener {
            if (editText.text.toString().trim().isNotEmpty() || editText.text.toString().trim()
                    .isNotBlank()
            ) {
                val number: Int = editText.text.toString().toInt()



                if (number < random) {


                    textView.text = "Wrong! , guess the higher number"
                    editText.text.clear()
                    count++
                    attempShowing.text = "Attemp = $count"
                } else if (number > random) {

                    textView.text = "Wrong! , guess the lower number"
                    editText.text.clear()
                    count++
                    attempShowing.text = "Attemp = $count"
                } else {
                    textView.text = "GREAT! , you guess the right number"

                }
            }
        }

        imageButtonReset.setOnClickListener {
                reset()
        }

    }

    fun reset() {
        random = nextInt(1,1000)
        textView.text = "Press HappyFace to check your answer"
        count = 0
        attempShowing.text = "Attemp = $count"
        editText.text.clear()
    }
}