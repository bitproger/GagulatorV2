package com.example.gagulator2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*enableEdgeToEdge()*/
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets*/
        val NumIn: TextView = findViewById(R.id.textView)
        val One: Button = findViewById(R.id.one)
        val Two: Button = findViewById(R.id.two)
        val Three: Button = findViewById(R.id.three)
        val Four: Button = findViewById(R.id.four)
        val Five: Button = findViewById(R.id.five)
        val Six: Button = findViewById(R.id.six)
        val Seven: Button = findViewById(R.id.seven)
        val Eight: Button = findViewById(R.id.eight)
        val Nine: Button = findViewById(R.id.nine)
        val Zero: Button = findViewById(R.id.zero)
        val Clear: Button = findViewById(R.id.clear)
        val Plus: Button = findViewById(R.id.plus)
        val Minus: Button = findViewById(R.id.minus)
        val Mult: Button = findViewById(R.id.mult)
        val Expon: Button = findViewById(R.id.expon)
        val Extract: Button = findViewById(R.id.extract)
        val Split: Button = findViewById(R.id.split)
        val Factorial: Button = findViewById(R.id.factorial)
        val Procent: Button = findViewById(R.id.procent)
        val Equally: Button = findViewById(R.id.equall)
        var Nums = mutableMapOf("FNum" to 0.0,"SNum" to 0.0,"action" to "None","status" to "nonready","Qu" to "FNum")
        println("Vars inits")

        val buttons: List<Button> = listOf(One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero)
        val actionButtons: List<Button> = listOf(Plus,Minus,Mult,Expon,Split,Extract)
        fun ToNumIn(But: Button) {
            println("ToNumIn Started")
            if (Nums["Qu"] == "FNum") {
                NumIn.text = "${NumIn.text}${But.text}"
                Nums["FNum"] = NumIn.text.toString().toDouble()


            }else if(Nums["Qu"] == "SNum" && Nums["action"] != "None") {
                NumIn.text = "${NumIn.text}${But.text}"
                Nums["SNum"] = NumIn.text.toString().toDouble()
                Nums["status"] = "ready"
            }

        }
        println("good")

        for (i in buttons) {
            i.setOnClickListener() {ToNumIn(i)}

        }
        for (i in actionButtons) {
            i.setOnClickListener() { Nums["action"] = i.text.toString()
                NumIn.text = ""
                NumIn.hint = Nums["FNum"].toString()
                Nums["Qu"] = "SNum"
            }

        }
        Equally.setOnClickListener() { if (Nums["status"] == "ready") {
            var result: String = actions().cout(Nums["FNum"] as Double,Nums["SNum"] as Double,Nums["action"] as String)

            if (result != "Error") {
                NumIn.text = result
                Nums["FNum"] = result.toDouble()
            } else {
                NumIn.text = ""
                NumIn.hint = "На 0 делить нельзя долбаеб"
                Nums["FNum"] = 0.00
                Nums["SNum"] = 0.00
                Nums["action"] = "None"
                Nums["Qu"] = "FNum"

            }




        } }

        Clear.setOnClickListener() {
            NumIn.text = ""
            NumIn.hint = ""
            Nums["FNum"] = 0.00
            Nums["SNum"] = 0.00
            Nums["action"] = "None"
            Nums["Qu"] = "FNum"

        }

        Factorial.setOnClickListener() {
            NumIn.text = actions().factorial(NumIn.text.toString().toInt()).toDouble().toString()
            Nums["FNum"] = NumIn.text.toString().toDouble()

        }

        Procent.setOnClickListener() { if (Nums["status"] == "ready") {
            NumIn.text = "${NumIn.text}%"
            var result = actions().procent(Nums["FNum"] as Double,Nums["SNum"] as Double)

            Nums["SNum"] = result






        } }



    }



    }
