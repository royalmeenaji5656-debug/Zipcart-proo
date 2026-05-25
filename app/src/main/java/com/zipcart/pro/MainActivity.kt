package com.zipcart.pro

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var cartCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cart Logic
        val cartBadge = findViewById<TextView>(R.id.cart_badge)
        cartBadge.setOnClickListener { startActivity(Intent(this, CartActivity::class.java)) }

        // Search Logic
        val searchBar = findViewById<EditText>(R.id.search_bar)
        searchBar.setOnEditorActionListener { v, _, _ ->
            Toast.makeText(this, "Searching for: ${v.text}", Toast.LENGTH_SHORT).show()
            true
        }

        // Profile Navigation
        findViewById<LinearLayout>(R.id.nav_profile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // Add to Cart Action
        findViewById<Button>(R.id.btn_buy_iphone).setOnClickListener {
            cartCount++
            cartBadge.text = "🛒 $cartCount"
            Toast.makeText(this, "Item added to Cart!", Toast.LENGTH_SHORT).show()
        }
    }
}
