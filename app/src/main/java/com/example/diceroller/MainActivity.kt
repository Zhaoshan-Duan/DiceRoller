package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // diceImage field
    lateinit var diceImage: ImageView
    lateinit var diceText: TextView
    private lateinit var binding: ActivityMainBinding

    private var currentRoll = 1
    private var useRedSet = true
    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // bind views
        diceText = binding.diceText
        diceImage = binding.diceIv

        val rollButton: Button = binding.rollButton
        val changeDiceBtn = binding.changeDiceBtn
        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice() }
        changeDiceBtn.setOnClickListener{ changeDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    private fun changeDice() {
        useRedSet = !useRedSet
        updateDiceImage()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        currentRoll = dice.roll()

        diceText.text = currentRoll.toString()

        updateDiceImage()

        // Update the content description
        diceImage.contentDescription = currentRoll.toString()
    }

    private fun updateDiceImage() {
        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (currentRoll) {
            1 -> if (useRedSet) R.drawable.red_dice_dice_1 else R.drawable.dice_1
            2 -> if (useRedSet) R.drawable.red_dice_dice_2 else R.drawable.white_dice_dice_2
            3 -> if (useRedSet) R.drawable.red_dice_dice_3 else R.drawable.dice_3
            4 -> if (useRedSet) R.drawable.red_dice_dice_4 else R.drawable.dice_4
            5 -> if (useRedSet) R.drawable.red_dice_dice_5 else R.drawable.dice_5
            else -> if (useRedSet) R.drawable.red_dice_dice_6 else R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        // just a setter, dont think too much
        diceImage.setImageResource(drawableResource)
    }
}

