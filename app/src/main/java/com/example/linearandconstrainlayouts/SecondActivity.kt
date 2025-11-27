package com.example.linearandconstrainlayouts

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.linearandconstrainlayouts.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {

    private val viewModel: TenantViewModel by viewModels()
    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Set up DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.second_activity)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Receive data from intent
        val receivedFirstName = intent.getStringExtra("TENANT_NAME")
        val receivedSecondName = intent.getStringExtra("TENANT_SECOND_NAME")
        val receivedApartment = intent.getStringExtra("TENANT_APARTMENT")

        // Set values in ViewModel
        viewModel.setFirstName(receivedFirstName)
        viewModel.setSecondName(receivedSecondName)
        viewModel.setApartmentNumber(receivedApartment)
    }
}
