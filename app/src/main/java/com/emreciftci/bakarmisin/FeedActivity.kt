package com.emreciftci.bakarmisin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        val feedQrCode: ImageView = findViewById(R.id.feedQrCode)
        val feedlocations: ImageView = findViewById(R.id.feedlocations)

        val actionBar = layoutInflater.inflate(R.layout.custom_app_bar, null)

        // Set the custom action bar as the action bar
        supportActionBar?.apply {
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            setCustomView(
                actionBar,
                ActionBar.LayoutParams(
                    ActionBar.LayoutParams.MATCH_PARENT,
                    ActionBar.LayoutParams.WRAP_CONTENT
                )
            )
            setDisplayHomeAsUpEnabled(true)
        }

        // Set the content view for the activity


        feedlocations.setOnClickListener {
            startMapActivity()
        }

        feedQrCode.setOnClickListener {
            startQrActivity()
        }
    }

    private fun startMapActivity() {
        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
    }

    private fun startQrActivity() {
        val intent = Intent(this, QrActivity::class.java)
        startActivity(intent)
    }
}