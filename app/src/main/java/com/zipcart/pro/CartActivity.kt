package com.zipcart.pro

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        findViewById<Button>(R.id.btn_checkout).setOnClickListener {
            Toast.makeText(this, "Order Placed Successfully! 🎉", Toast.LENGTH_LONG).show()
            finish() // आर्डर होने के बाद वापस होम पेज पर भेज देगा
        }
    }
}
