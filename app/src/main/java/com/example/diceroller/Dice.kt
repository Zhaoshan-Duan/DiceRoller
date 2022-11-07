package com.example.diceroller

/**
 * Dice with a fixed number of sides.
 */
data class Dice (private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {

        // two ways to get random numbers

        // Kotlin like
        return (1..numSides).random()

        // Java like
        // return Random().nextInt(6) + 1
    }
}