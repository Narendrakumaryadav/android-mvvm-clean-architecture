package com.narendra.newsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/**
 * Launcher Activity (Entry point) of this application
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}