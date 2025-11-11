package com.example.linearandconstrainlayouts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    private val TAG = "LIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Drawer and Toolbar setup
        drawerLayout = findViewById(R.id.drawer_layout)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val navView: NavigationView = findViewById(R.id.nav_view)

        setSupportActionBar(toolbar)

        // When the navigation icon is clicked → open drawer
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Handling Nav Menu Clicks
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.nav_home -> {
                    Toast.makeText(this, "Dashboard clicked", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true

                }

                R.id.nav_settings -> {
                    Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_logout -> {
                    Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                else -> false
            }
        }


        // Your existing UI logic
        val FirstName = findViewById<EditText>(R.id.editTextFirstName)
        val AddTenantButton =  findViewById<Button>(R.id.button9)
        val OutputTextView = findViewById<TextView>(R.id.textView8)
        val OpenSecondActivity = findViewById<Button>(R.id.WelcomeScreen)

        AddTenantButton.setOnClickListener {
            val FirstNameInput = FirstName.text.toString()
            OutputTextView.text = "Name: $FirstNameInput "
        }

        OpenSecondActivity.setOnClickListener {
            val FirstNameInput = FirstName.text.toString()
            val intent = Intent(this, SecondActivityclass::class.java)
            intent.putExtra("TENANT_NAME", FirstNameInput)
            startActivity(intent)
        }
        Log.d(TAG, "MainActivity - onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity - onDestroy")
    }
}
