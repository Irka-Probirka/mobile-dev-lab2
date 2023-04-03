package com.example.lab2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = findViewById<EditText>(R.id.editText_A)
        val b = findViewById<EditText>(R.id.editText_B)
        val c = findViewById<EditText>(R.id.editText_C)
        val result = findViewById<TextView>(R.id.textView_result)
        val button = findViewById<Button>(R.id.button)

        val A = a.toString().format("%.2f").toDoubleOrNull()
        val B = b.toString().format("%.2f").toDoubleOrNull()
        val C = c.toString().format("%.2f").toDoubleOrNull()

        button.setOnClickListener() {
            result.text = "a=$A, b=$B, c=$C"
            if (A != null && B != null && C != null) {
                result.text = "Ошибка в вводе данных"
            }
            else {
                val disc: Double = discriminant(A!!, B!!, C!!)

                if (disc == 0.0) {
                    val x = (-B) / (2 * A)
                    result.text = "x1 = x2 = $x"
                } else if (disc > 0.0) {
                    val x1 = (-B + sqrt(disc)) / (A * 2)
                    val x2 = (-B - sqrt(disc)) / (A * 2)
                    result.text = "x1 = $x1, x2 = $x2"
                }
                else{
                    result.text = "Нет корней"
                }
            }
        }
    }

    private fun discriminant(a: Double, b: Double, c: Double): Double {
        return sqr(b) - 4 * a * c
    }

    fun sqr(x: Double): Double = x * x

}