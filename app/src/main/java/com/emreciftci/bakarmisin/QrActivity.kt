package com.emreciftci.bakarmisin

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class QrActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)

        checkCameraPermission()

        val scanButton: Button = findViewById(R.id.scanButton)
        scanButton.setOnClickListener {
            scanQRCode()
        }
    }

    fun scanQRCode() {
        IntentIntegrator(this).initiateScan()
    }

    private fun checkCameraPermission() {
        val permission = Manifest.permission.CAMERA
        val granted = PackageManager.PERMISSION_GRANTED
        if (ContextCompat.checkSelfPermission(this, permission) != granted) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Handle the QR code scan result
        val result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents != null) {
                openUrl(result.contents)
            }
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}