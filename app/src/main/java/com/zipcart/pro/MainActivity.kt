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

        // 1. कार्ट और प्रोफाइल बटन का लॉजिक
        val cartBadge = findViewById<TextView>(R.id.cart_badge)
        cartBadge.setOnClickListener { startActivity(Intent(this, CartActivity::class.java)) }

        // 2. बॉटम नेविगेशन के बटन (Profile पर क्लिक करने पर प्रोफाइल खुलेगी)
        // ध्यान दें: activity_main.xml में आईडी के हिसाब से इसे सेट किया है
        val btnProfile = findViewById<LinearLayout>(R.id.nav_profile)
        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // 3. सर्च बार का लॉजिक (सर्च करते ही मैसेज दिखाएगा)
        val searchBar = findViewById<EditText>(R.id.search_bar)
        searchBar.setOnEditorActionListener { v, _, _ ->
            Toast.makeText(this, "Searching for: ${v.text}", Toast.LENGTH_SHORT).show()
            true
        }

        // प्रोडक्ट बटन
        findViewById<Button>(R.id.btn_buy_iphone).setOnClickListener {
            cartCount++
            cartBadge.text = "🛒 $cartCount"
            Toast.makeText(this, "iPhone added!", Toast.LENGTH_SHORT).show()
        }
    }
}
