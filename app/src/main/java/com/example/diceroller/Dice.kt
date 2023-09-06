package com.example.diceroller

/**
 * Dice with a fixed number of sides.
 */
class Dice(private val numSides: Int) {

    var res: Int = 0

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        res = (1..numSides).random()
        return res
    }
}