package com.example.exercise1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.exercise1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private val display: Display = Display("Loan :")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //binding.display = display
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonCalculate.setOnClickListener{
            calculate(it)
        }
        binding.buttonReset.setOnClickListener{
            clearAll()
        }

    }

    private fun calculate(view: View){
        Toast.makeText(this, "Calculated", Toast.LENGTH_SHORT).show()

        var carLoan: Int = binding.editTextCarPrice.text.toString().toInt() - binding.editTextDownPayment.text.toString().toInt()
        var carInterest: Double = carLoan.toDouble() * (binding.editTextInterestRate.text.toString().toDouble() / 100) * binding.editTextLoanPeriod.text.toString().toDouble()
        var monthlyPayment: Double = (carLoan.toDouble() + carInterest) / binding.editTextLoanPeriod.text.toString().toDouble() / 12

        binding.apply {
            binding.textViewLoan.text = "Loan : RM " + carLoan.toString()
            binding.textViewInterest.text = "Interest : RM " + carInterest.toString()
            binding.textViewMonthlyRepayment.text = "Monthly Repayment : RM " + monthlyPayment.toString()
        }


    }


    private fun clearAll(){
        Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show()

        binding.editTextCarPrice.text = null
        binding.editTextDownPayment.text = null
        binding.editTextLoanPeriod.text = null
        binding.editTextInterestRate.text = null

        binding.textViewLoan.text = "Loan :"
        binding.textViewInterest.text = "Interest :"
        binding.textViewMonthlyRepayment.text = "Monthly Repayment :"

    }


}
