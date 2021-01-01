package com.example.sejaumguia.ui.main.view

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.example.sejaumguia.R

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        errorActivityAction()
    }

    private fun errorActivityAction(){
        val btnRestart = findViewById<LottieAnimationView>(R.id.animation_error_button_restart)

        btnRestart.setOnClickListener {
                Toast.makeText(this,"Testando",Toast.LENGTH_LONG).show()
        }
    }

}