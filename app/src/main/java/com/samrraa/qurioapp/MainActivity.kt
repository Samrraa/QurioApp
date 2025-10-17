package com.samrraa.qurioapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.samrraa.qurioapp.databinding.ActivityMainBinding
import com.samrraa.qurioapp.datastore.QurioPreferences
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var qurioPreferences: QurioPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as QurioApp).appComponent.inject(this)

        qurioPreferences = QurioPreferences(this)

        checkOnboardingStatus()
    }

    private fun checkOnboardingStatus() {
        lifecycleScope.launch {
            val isComplete = qurioPreferences.onboardingCompleteFlow.firstOrNull() ?: false

            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController
            val navGraph = navController.navInflater.inflate(R.navigation.qurio_nav_graph)

            navGraph.setStartDestination(
                if (isComplete) R.id.homeFragment else R.id.onboardingFragment
            )

            navController.graph = navGraph
        }
    }

}