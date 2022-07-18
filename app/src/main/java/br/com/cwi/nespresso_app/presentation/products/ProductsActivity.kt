package br.com.cwi.nespresso_app.presentation.products

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.presentation.bag.BagActivity
import br.com.cwi.nespresso_app.databinding.ActivityProductsBinding
import br.com.cwi.nespresso_app.presentation.favorites.FavoritesActivity
import br.com.cwi.nespresso_app.presentation.products.accessorie.AccessorieActivity
import br.com.cwi.nespresso_app.presentation.products.coffee.CoffeeActivity
import br.com.cwi.nespresso_app.presentation.products.machine.MachineActivity

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpProductsActions()
        setUpBottomNavigation()
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }

    override fun onResume() {
        super.onResume()
        binding.contentBottomNavigation.bottomNavigation.selectedItemId = R.id.products_menu
    }

    private fun setUpProductsActions(){
        binding.contentCoffees.root.setOnClickListener{
            val intent = Intent(this, CoffeeActivity::class.java)

            startActivity(intent)
        }

        binding.contentMachines.root.setOnClickListener{
            val intent = Intent(this, MachineActivity::class.java)

            startActivity(intent)
        }

        binding.contentAccessories.root.setOnClickListener{
            val intent = Intent(this, AccessorieActivity::class.java)

            startActivity(intent)
        }
    }

    private fun setUpBottomNavigation() {
        binding.contentBottomNavigation.bottomNavigation.selectedItemId = R.id.products_menu

        binding.contentBottomNavigation.bottomNavigation.setOnNavigationItemSelectedListener {

            when(it.itemId) {

                R.id.favorites_menu -> {
                    startActivity(Intent(this, FavoritesActivity::class.java))
                }

                R.id.bag_menu -> {
                    startActivity(Intent(this, BagActivity::class.java))
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}