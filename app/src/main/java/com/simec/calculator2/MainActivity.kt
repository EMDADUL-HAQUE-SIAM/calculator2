package com.simec.calculator2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.simec.calculator2.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var lastNumeric = false
    var stateError = false
    var lastDot = false
    private lateinit var expression: Expression
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun operatorbutton(view: View) {
        if (!stateError && lastNumeric){

            binding.dataTextView.append((view as Button).text)
            lastDot = false
            lastNumeric = false
            onEqualClick(view)
        }
    }
    fun onEqualClick(view: View) {
        //onEqualClick()
        //binding.dataTextView.text = binding.resultTextView.text.toString().drop(1)
        if (lastNumeric && !stateError){

            try {
                val txt = binding.dataTextView.text.toString()
                expression = ExpressionBuilder(txt).build()
                val format = DecimalFormat()
                val result= expression.evaluate()
                binding.resultTextView.visibility = View.VISIBLE

                binding.resultTextView.text = "=" + format.format(result)
            }catch (ex : ArithmeticException){
                Log.e("evaluate error", ex.toString())
                binding.resultTextView.text = "Error"
                stateError = true
                lastNumeric = false
            }
        }
    }
    fun onDigitClick(view: View) {

        if (stateError){
            binding.dataTextView.text = (view as Button).text
            stateError = false
        }else{
            binding.dataTextView.append((view as Button).text)
        }
        lastNumeric = true
        //onEqualClick()
    }
    fun onBackClick(view: View) {
        binding.dataTextView.text = binding.dataTextView.text.toString().dropLast(1)

        try {
            val lastChar = binding.dataTextView.text.toString().last()
            if (lastChar.isDigit()){
                onEqualClick(view)
            }
        }catch (e: Exception){
            binding.resultTextView.text= ""
            binding.resultTextView.visibility = View.GONE
            Log.e("last char error",e.toString())
        }
    }
    fun onClearClick(view: View) {

        binding.dataTextView.text = ""
        lastNumeric = false

    }
}