package com.example.androbasics

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.androbasics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.unitSelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (binding.unitSelector.selectedItem == "°c") {
                    convertTo = "f"
                    binding.convertBtn.text = "Convert to Fahrenheit"
                }
                else {
                    convertTo = "c"
                    binding.convertBtn.text = "Convert to Celsius"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Not required here
            }
        }
    }

    var convertTo = "c"

    @SuppressLint("SetTextI18n")
    fun convert(view: View) {
        if (binding.inputBox.text.isEmpty()) {
            binding.resultOutput.text = "Input a value first"
        }

        val cValue = binding.inputBox.text.toString().toDouble()

        val result: String

        if (convertTo == "f") {
            result = String.format("%.2f", (((cValue * 9) / 5) + 32)) + "°f"
        }
        else {
            result = String.format("%.2f", (((cValue - 32) * 5) / 9)) + "°c"
        }
        binding.resultOutput.text = result
    }
}
