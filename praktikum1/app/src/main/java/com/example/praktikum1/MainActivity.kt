package com.example.praktikum1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        //agar saat apk dimulai, dadu langsung teracak
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6) //instansiasi objek dari class Dice ke dalam var dice
        val dice2 = Dice(6)
        val diceRoll = dice.roll() //mengembalikan nilai acak lalu disimpan ke diceRoll
        val diceRoll2 = dice2.roll()

        //menemukan image dari layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val drawableResource2 = when (diceRoll2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = diceRoll.toString()

        doubleChecker(diceRoll, diceRoll2)
    }

    private fun doubleChecker(dadu1: Int, dadu2: Int){
        //function untuk melalakukan check nilai antara kedua dadu
        if (dadu1 == dadu2) Toast.makeText(this,"Selamat Anda mendapat Dadu Double!", Toast.LENGTH_SHORT).show()
        else Toast.makeText(this, "Maaf Anda belum beruntung", Toast.LENGTH_SHORT).show()
    }
}

class Dice(private val numSide: Int) {
    //function yang memngembalikan nilai acak
    fun roll(): Int {
        return (1..numSide).random()
    }
}