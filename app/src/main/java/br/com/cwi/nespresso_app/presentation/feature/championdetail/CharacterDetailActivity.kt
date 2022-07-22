package br.com.cwi.nespresso_app.presentation.feature.championdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityChampionDetailBinding
import br.com.cwi.nespresso_app.domain.entity.Champion
import br.com.cwi.nespresso_app.presentation.feature.extension.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

const val CHAVE_ID = "CHAVE_ID"

class CharacterDetailActivity : AppCompatActivity() {

    private val viewModel: ChampionDetailViewModel by viewModel()

    private lateinit var binding: ActivityChampionDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChampionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpViewModel()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setUpViewModel() {
        val id = intent.getStringExtra(CHAVE_ID)

        viewModel.data.observe(this) {
            loadCharacterDetails(it)
        }

        id?.let { viewModel.fetchCharacter(it) }
        
    }

    private fun loadCharacterDetails(champion: Champion) {
        with(binding) {
            ivCharacter.loadImage(champion.image_splash)
            toolbarLayout.title = champion.name
            contentScrolling.tvCharacterDescription.text = champion.blurb


        }
    }


}