package br.com.cwi.nespresso_app.presentation.feature.champions

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityChampionBinding
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.presentation.feature.championdetail.CHAVE_ID
import br.com.cwi.nespresso_app.presentation.feature.championdetail.CharacterDetailActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChampionActivity() : BaseBottomNavigation() {

    private val viewModel: ChampionViewModel by viewModel()

    private lateinit var binding: ActivityChampionBinding

    override val currentTab: Int = R.id.champions_menu

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChampionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel.characters.observe(this) { lista ->

            val recyclerView = binding.rvChampions
            recyclerView.adapter = ChampionAdapter(context = this, lista, ::onClickCharacter)
            recyclerView.layoutManager = GridLayoutManager(this@ChampionActivity, 3)

        }
        viewModel.fetchCharacters()
    }

    private fun onClickCharacter(id: String) {
        startActivity(
            Intent(this, CharacterDetailActivity::class.java).apply {
                putExtra(CHAVE_ID, id)
            }
        )
    }



}