package com.example.alertdialog

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var number:EditText
    private lateinit var perform:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        number = findViewById(R.id.editNumber)
        perform = findViewById(R.id.calculate)
        perform.setOnClickListener {
            if(validate(number.text.toString())){
                AlertDialog.Builder(this)
                    .apply{
                        setCancelable(false)
                        setTitle("Hello")
                        setMessage(getString(R.string.message,number.text.toString()))
                        setPositiveButton(getString(R.string.positive,number.text.toString())){_,_->
                            val temp = number.text.toString().toInt() + number.text.toString().toInt()
                            number.setText(temp.toString())
                        }
                        setNegativeButton(getString(R.string.negative,number.text.toString())){_,_->
                            val temp = number.text.toString().toInt() - number.text.toString().toInt()
                            number.setText(temp.toString())
                        }
                        setNeutralButton(getString(R.string.neutral)){_,_->
                            number.text = null
                        }
                        show()
                    }
            }
        }
    }

    private fun validate(text: String?):Boolean {
        val isCorrect: Boolean
        if(text == "" ) {
            isCorrect = false
            number.error = "Enter Number.."
        }
        else isCorrect = true
            return isCorrect
    }
}