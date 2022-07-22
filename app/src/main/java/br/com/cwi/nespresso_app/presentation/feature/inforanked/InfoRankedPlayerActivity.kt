package br.com.cwi.nespresso_app.presentation.feature.inforanked

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.nespresso_app.databinding.ActivityInfoRankedPlayerBinding
import br.com.cwi.nespresso_app.domain.entity.InfoPlayer
import br.com.cwi.nespresso_app.domain.entity.InfoPlayerRanked
import br.com.cwi.nespresso_app.presentation.feature.extension.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

const val KEY_NICK = "KEY_NICK"

class InfoRankedPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoRankedPlayerBinding

    private val viewModel: InfoRankedPlayerViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoRankedPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpViewModel()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setUpViewModel() {
        val id = intent.getStringExtra(KEY_NICK)

        viewModel.player.observe(this) {
            loadCharacterDetails(it)
        }

        id?.let { viewModel.fetchInfoPlayer(it) }

    }

    private fun loadCharacterDetails(infoPlayer: InfoPlayer) {
        with(binding) {
            ivIconPlayer.loadImage("http://ddragon.leagueoflegends.com/cdn/12.13.1/img/profileicon/" + infoPlayer.profileIconId + ".png")
            tvNickPlayer.text = infoPlayer.name
            tvNickLvl.text = "Level:" + infoPlayer.summonerLevel.toString()

        }
    }


}