package com.example.gagulator2

import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.sqrt

class actions {
    fun cout(fnum: Double,snum: Double,action: String): String {
        when (action) {
            "+" -> return (fnum + snum).toString()
            "-" -> return (fnum - snum).toString()
            "*" -> return (fnum * snum).toString()
            "^" -> return fnum.pow(snum).toString()
            "√" -> if (snum != 0.00) { return fnum.pow(1.00 / snum).toString() } else { return  "Error" }
            "/" -> if (snum != 0.00) { return (fnum / snum).toString() } else { return "Error" }
            else -> return snum.toString()

        }

        return 0.00.toString()
    }

    fun factorial(n: Int): Int {
        var result = 1
        for (i in 1..n) {
            result *= i
        }
        return result
    }

    fun procent(fnum: Double,snum: Double): Double {

        return ((fnum / 100) * snum)




    }



}






