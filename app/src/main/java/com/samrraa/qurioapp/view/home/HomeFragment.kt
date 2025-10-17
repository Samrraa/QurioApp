package com.samrraa.qurioapp.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentHomeBinding
import com.samrraa.qurioapp.presenter.HomePresenter
import com.samrraa.qurioapp.repository.GameRepository
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, IHomeView, HomePresenter>(), IHomeView {

    @Inject
    lateinit var repository: GameRepository

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initPresenter() = HomePresenter(repository, this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToQuestionFragment())
        }
    }
}