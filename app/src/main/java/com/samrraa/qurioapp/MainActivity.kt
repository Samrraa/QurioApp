package com.samrraa.qurioapp

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.samrraa.TimeFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load TimeFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, TimeFragment())
                .commit()
        }
    }
}