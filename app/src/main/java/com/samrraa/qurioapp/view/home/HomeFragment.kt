package com.samrraa.qurioapp.view.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.samrraa.qurioapp.QurioApp
import com.samrraa.qurioapp.R
import com.samrraa.qurioapp.base.BaseFragment
import com.samrraa.qurioapp.databinding.FragmentHomeBinding
import com.samrraa.qurioapp.model.Character
import com.samrraa.qurioapp.presenter.HomePresenter
import com.samrraa.qurioapp.repository.GameRepository
import com.samrraa.qurioapp.view.games.model.GameCategoryUi
import com.samrraa.qurioapp.view.lastgames.LastGameAdapter
import com.samrraa.qurioapp.view.lastgames.SpaceItemDecoration
import com.samrraa.qurioapp.view.lastgames.model.History
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, IHomeView, HomePresenter>(), IHomeView {
    @Inject
    lateinit var repository: GameRepository

    override fun onAttach(context: Context) {
        (requireActivity().application as QurioApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initPresenter() = HomePresenter(this, repository)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleView()
        handleClicks()
        presenter.getCharacter()
        presenter.getLives()
        presenter.getPoints()
        presenter.getAwards()
        presenter.getGames()
        presenter.getLastGames()
    }

    private fun handleClicks() {
        binding.gamesSection.btnAll.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToGamesFragment()
            )
        }
        binding.lastGamesSection.btnAll.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToLastGamesFragment()
            )
        }
    }

    private fun handleView() {
        binding.gamesSection.title.text = getString(R.string.games)
        binding.lastGamesSection.title.text = getString(R.string.last_games)
        handleLastGamesVisibility()
    }

    override fun onGetCharacterSuccess(character: Character) {
        binding.topBar.characterName.text = character.name
    }

    override fun onGetLastGamesSuccess(lastGames: List<History>) {
        handleLastGamesVisibility()
    }

    private fun handleLastGamesVisibility() {
        if (presenter.lastGames.isEmpty()) {
            binding.lastGamesSection.root.visibility = View.GONE
            binding.rvLastGames.visibility = View.GONE
        } else {
            binding.lastGamesSection.root.visibility = View.VISIBLE
            binding.rvLastGames.visibility = View.VISIBLE
            binding.rvLastGames.apply {
                adapter = LastGameAdapter(presenter.lastGames.take(3))
                addItemDecoration(SpaceItemDecoration(requireContext(), 12))
            }
        }
    }

    override fun onGetGamesSuccess(games: List<GameCategoryUi>) {}

    override fun onGetLivesSuccess(lives: Flow<Int>) {
        lifecycleScope.launch {
            lives.collect {
                binding.statistics.livesCount.text = it.toString()
            }
        }
    }

    override fun onGetPointsSuccess(points: Flow<Int>) {
        lifecycleScope.launch {
            points.collect {
                binding.statistics.pointsCount.text = it.toString()
            }
        }
    }

    override fun onGetAwardsSuccess(awards: Flow<Int>) {
        lifecycleScope.launch {
            awards.collect {
                binding.statistics.awardsCount.text = it.toString()
            }
        }
    }
}
