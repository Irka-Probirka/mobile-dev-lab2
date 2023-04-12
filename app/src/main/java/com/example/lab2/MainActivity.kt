package com.example.lab2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = findViewById<EditText>(R.id.editText_A)
        val b = findViewById<EditText>(R.id.editText_B)
        val c = findViewById<EditText>(R.id.editText_C)
        val result = findViewById<TextView>(R.id.textView_result)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener() {
            val A = a.text.toString().format("%.2f").toDouble()
            val B = b.text.toString().format("%.2f").toDouble()
            val C = c.text.toString().format("%.2f").toDouble()

            if (A != 0.0) {

                val disc: Double = discriminant(A, B, C)

                if (disc == 0.0) {
                    val x = (-B) / (A * 2)
                    result.text = "x = ${x.toInt()}"
                } else if (disc > 0.0) {
                    val x1 = (-B + sqrt(disc)) / (A * 2)
                    val x2 = (-B - sqrt(disc)) / (A * 2)
                    result.text = "x1 = ${x1.toInt()}, x2 = ${x2.toInt()}"
                } else {
                    result.text = "Нет корней"
                }
            }
            else{
                result.text = "Не является квадратным уравнением"
            }
        }
    }

    private fun discriminant(a: Double, b: Double, c: Double): Double {
        return sqr(b) - 4 * a * c
    }

    fun sqr(x: Double): Double = x * x
}