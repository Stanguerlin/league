package br.com.cwi.nespresso_app.presentation.favorites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.presentation.bag.BagActivity
import br.com.cwi.nespresso_app.databinding.ActivityFavoritesBinding
import br.com.cwi.nespresso_app.presentation.products.ProductsActivity

class FavoritesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomNavigation()
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onResume() {
        super.onResume()
        binding.contentBottomNavigation.bottomNavigation.selectedItemId = R.id.favorites_menu
    }

    private fun setUpBottomNavigation() {
        binding.contentBottomNavigation.bottomNavigation.selectedItemId = R.id.products_menu

        binding.contentBottomNavigation.bottomNavigation.setOnNavigationItemSelectedListener {

            when(it.itemId) {

                R.id.products_menu -> {
                    startActivity(Intent(this, ProductsActivity::class.java))
                }

                R.id.bag_menu -> {
                    startActivity(Intent(this, BagActivity::class.java))
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}