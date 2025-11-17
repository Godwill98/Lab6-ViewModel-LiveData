package com.example.linearandconstrainlayouts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private val viewModel: TenantViewModel by viewModels()  // ViewModel instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Drawer and Toolbar setup
        drawerLayout = findViewById(R.id.drawer_layout)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val navView: NavigationView = findViewById(R.id.nav_view)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

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

        // UI Elements
        val firstNameEditText = findViewById<EditText>(R.id.editTextFirstName)
        val addTenantButton = findViewById<Button>(R.id.button9)
        val outputTextView = findViewById<TextView>(R.id.textView8)
        val openSecondActivity = findViewById<Button>(R.id.WelcomeScreen)

        // Observe LiveData from ViewModel
        viewModel.firstName.observe(this) { name ->
            outputTextView.text = "Name: $name"
        }

        // Add Tenant button updates ViewModel
        addTenantButton.setOnClickListener {
            val firstNameInput = firstNameEditText.text.toString()
            viewModel.setFirstName(firstNameInput)  // update ViewModel
        }

        // Welcome button opens SecondActivity
        openSecondActivity.setOnClickListener {
            val firstNameInput = firstNameEditText.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("TENANT_NAME", firstNameInput)
            startActivity(intent)
        }
    }
}
