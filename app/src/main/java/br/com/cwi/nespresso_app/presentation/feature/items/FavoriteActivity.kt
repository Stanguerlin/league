package br.com.cwi.nespresso_app.presentation.feature.items

import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ActivityFavoriteBinding
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoriteActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityFavoriteBinding

    override val currentTab: Int = R.id.items_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.contentBottomNavigation.root

}