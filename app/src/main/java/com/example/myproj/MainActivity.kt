package com.example.myproj

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myproj.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity","MainActivity started")

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.MainActivityBtnSendEmail.setOnClickListener {
            Log.d("MainActivity","btnShare clicked!")

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(resources.getString(R.string.MainActivityChooserEmail)))

            val title = resources.getString(R.string.MainActivityChooserTitle)

            val chooser = Intent.createChooser(intent, title)

            try {
                startActivity(chooser)
            } catch (e: ActivityNotFoundException) {
            }
        }



    }
}