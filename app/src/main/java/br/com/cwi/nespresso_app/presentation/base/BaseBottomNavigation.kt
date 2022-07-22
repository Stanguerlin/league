package br.com.cwi.nespresso_app.presentation.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.presentation.feature.champions.ChampionActivity
import br.com.cwi.nespresso_app.presentation.feature.items.FavoriteActivity
import br.com.cwi.nespresso_app.presentation.feature.initial.InitialActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseBottomNavigation : AppCompatActivity() {

    abstract val currentTab: Int

    abstract fun getBottomNavigation(): BottomNavigationView

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onResume() {
        super.onResume()
        setUpBottomNavigationActions()
        selectCurrentTab()
    }

    private fun setUpBottomNavigationActions() {

        getBottomNavigation().setOnItemSelectedListener {
            if (it.itemId != this.currentTab) when (it.itemId) {
                R.id.initial_menu -> {
                    val intent = Intent(this, InitialActivity::class.java)
                    startActivity(intent)
                }
                R.id.items_menu -> {
                    val intent = Intent(this, FavoriteActivity::class.java)
                    startActivity(intent)
                }
                R.id.champions_menu -> {
                    val intent = Intent(this, ChampionActivity::class.java)
                    startActivity(intent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun selectCurrentTab() {
        getBottomNavigation().selectedItemId = currentTab
    }
}