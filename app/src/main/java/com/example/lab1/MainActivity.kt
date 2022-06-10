package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var number1:Button
    private lateinit var number2:Button
    private lateinit var score:TextView
    private var totalscore = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1=findViewById(R.id.number1)
        number2=findViewById(R.id.number2)
        score=findViewById(R.id.score)

        randomNumber()
        score.text="Points: $totalscore"

        //Button1 Action
        number1.setOnClickListener{
            val Bleft = Integer.parseInt(number1.text.toString())
            val Bright = Integer.parseInt(number2.text.toString())
            if (Bleft >= Bright) {
                totalscore++
                Toast.makeText(this, "Yes, You are Smart!!!", Toast.LENGTH_SHORT).show()
            }else {
                totalscore--
                Toast.makeText(this, "Alas!!!", Toast.LENGTH_SHORT).show()
            }
            var total = totalscore.toString()
            score.text="Points: $total"
            randomNumber()
        }
        //Button2 Action
        number2.setOnClickListener{
            val Bleft = Integer.parseInt(number1.text.toString())
            val Bright = Integer.parseInt(number2.text.toString())
            if (Bright >= Bleft) {
                totalscore++
                Toast.makeText(this, "Hurray!!!", Toast.LENGTH_SHORT).show()
            }else {
                totalscore--
                Toast.makeText(this, "It is incorrect, Unfortunately!!! ", Toast.LENGTH_SHORT).show()
            }
            var total = totalscore.toString()
            score.text="Points: $total"
            randomNumber()
        }


    }

    private fun randomNumber() {
        val random1= Random().nextInt(101)
        var random2=Random().nextInt(101)
        while(random1 == random2){
            random2 = Random().nextInt(101)
        }
        number1.text=random1.toString()
        number2.text=random2.toString()

    }

}