package com.example.nightlife.model

import java.text.DecimalFormat
import kotlin.random.Random


// Temporary class made to populate homescreen.
class Bars {
    var receivedNames = mutableListOf("Dorsia", "1656", "Toves Vinkælder", "Kurt Ravns Hytte", "Hive(Skrald)", "Tyrolia")
    val allBars = mutableListOf<Bar>()

    init {
        var t = 0
        val df = DecimalFormat("#.##")
        for (i in receivedNames) {
            val newBar = Bar(t, i, df.format(Random.nextDouble(0.0,5.0)))
            allBars.add(newBar)
            t++
        }
    }
}