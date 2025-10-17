package com.samrraa.qurioapp.view.onboarding

import android.annotation.SuppressLint
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

class SwipeGestureListener(
    private val onSwipeUp: () -> Unit
) : GestureDetector.SimpleOnGestureListener() {

    companion object {
        private const val SWIPE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        if (e1 == null) return false

        val diffY = e1.y - e2.y
        val diffX = e1.x - e2.x

        if (abs(diffY) > abs(diffX)) {
            if (abs(diffY) > SWIPE_THRESHOLD && abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    // Swipe up detected
                    onSwipeUp()
                    return true
                }
            }
        }
        return false
    }
}

@SuppressLint("ClickableViewAccessibility")
fun View.addSwipeUpGesture(onSwipeUp: () -> Unit) {
    val gestureDetector = GestureDetector(context, SwipeGestureListener(onSwipeUp))
    setOnTouchListener { _, event ->
        gestureDetector.onTouchEvent(event)
        false
    }
}