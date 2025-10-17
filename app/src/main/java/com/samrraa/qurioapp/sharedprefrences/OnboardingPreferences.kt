package com.samrraa.qurioapp.sharedprefrences

import android.content.Context

object OnboardingPreferences {
    private const val PREFS_NAME = "qurio_prefs"
    private const val KEY_IS_COMPLETE = "onboarding_complete"
    
    fun isComplete(context: Context): Boolean {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_IS_COMPLETE, false)
    }
}