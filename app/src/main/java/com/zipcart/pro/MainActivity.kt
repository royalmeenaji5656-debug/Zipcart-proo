package com.zipcart.pro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var cartCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cartBadge = findViewById<TextView>(R.id.cart_badge)
        val btnBuyIphone = findViewById<Button>(R.id.btn_buy_iphone)
        val btnBuySony = findViewById<Button>(R.id.btn_buy_sony)

        // कार्ट में आइटम जोड़ने का काम
        val addToCartAction = { itemName: String ->
            cartCount++
            cartBadge.text = "🛒 $cartCount"
            Toast.makeText(this, "$itemName added to your cart!", Toast.LENGTH_SHORT).show()
        }

        btnBuyIphone.setOnClickListener { addToCartAction("iPhone 15 Pro") }
        btnBuySony.setOnClickListener { addToCartAction("Sony Headphones") }

        // ऊपर कार्ट आइकॉन पर क्लिक करने पर Cart पेज खुलेगा
        cartBadge.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
}
