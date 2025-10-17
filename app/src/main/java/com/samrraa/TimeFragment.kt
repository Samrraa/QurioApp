package com.samrraa

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentTimeBinding

class TimeFragment : BaseFragment<FragmentTimeBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.timeLayout.blackBar) {
            post {
                val parentWidth = (parent as View).width
                val totalDuration = 12_000L

                val animator = ObjectAnimator.ofFloat(
                    this,
                    "translationX",
                    0f,
                    parentWidth.toFloat()
                ).apply {
                    this.duration = totalDuration
                    interpolator = LinearInterpolator()
                }

                val startTime = System.currentTimeMillis()
                val handler = Handler(Looper.getMainLooper())

                val updateRunnable = object : Runnable {
                    override fun run() {
                        val elapsed = System.currentTimeMillis() - startTime
                        val progress = ((elapsed.toFloat() / totalDuration) * 100)
                            .toInt()
                            .coerceAtMost(100)

                        binding.timeLayout.tvTime.text = "$progress Sec"

                        if (elapsed < totalDuration) handler.postDelayed(this, 100)
                    }
                }

                animator.start()
                handler.post(updateRunnable)
            }
        }
    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTimeBinding {
        return FragmentTimeBinding.inflate(inflater, container, false)
    }
}