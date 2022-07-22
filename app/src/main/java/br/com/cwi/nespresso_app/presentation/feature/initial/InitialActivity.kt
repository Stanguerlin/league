package br.com.cwi.nespresso_app.presentation.feature.initial

import android.content.Intent
import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityInitialBinding
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.presentation.feature.inforanked.InfoRankedPlayerActivity
import br.com.cwi.nespresso_app.presentation.feature.inforanked.KEY_NICK
import com.google.android.material.bottomnavigation.BottomNavigationView

class InitialActivity() : BaseBottomNavigation() {

    private lateinit var binding: ActivityInitialBinding

    override val currentTab: Int = R.id.initial_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        onSearchPlayer()
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

    private fun onSearchPlayer() {

        binding.myBtn.setOnClickListener {
            startActivity(Intent(this, InfoRankedPlayerActivity::class.java).apply {
                putExtra(KEY_NICK, binding.testeeSearch.text.toString())
            })
        }
    }
}