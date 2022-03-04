package com.vangood.guess_vm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.vangood.guess_vm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var secretNumber = SecretNumber()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MainActivity", "secret:" + secretNumber.secret)
    }

    fun check(veiw: View){
        val n = binding.edNumber.text.toString().toInt()
        println("number: $n")
        Log.d("MainActivity", "number:" + n)
        var diff = secretNumber.validate(n)
        var message = "You got it"
        if(diff < 0){
            message = "Bigger"
        } else { if (diff > 0) {
            message = "Smaller"
        }
        }
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this).
        setTitle("Message").
        setMessage(message).
        setPositiveButton("ok", null).
        show()
    }
}