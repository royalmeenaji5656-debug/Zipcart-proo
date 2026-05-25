package com.zipcart.pro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        findViewById<Button>(R.id.btn_logout).setOnClickListener {
            Toast.makeText(this, "Logged Out Successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            // पुरानी सारी हिस्ट्री क्लियर कर देगा ताकि बैक करने पर वापस न आ सके
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
