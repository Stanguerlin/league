package br.com.cwi.nespresso_app.presentation.products.coffee

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.mapper.CategoryMapper
import br.com.cwi.nespresso_app.data.mapper.CoffeeMapper
import br.com.cwi.nespresso_app.data.mapper.MachineMapper
import br.com.cwi.nespresso_app.data.repostory.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import br.com.cwi.nespresso_app.databinding.ActivityCoffeeBinding
import br.com.cwi.nespresso_app.domain.entity.Type
import br.com.cwi.nespresso_app.domain.repository.CoffeeRepository
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoffeeActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityCoffeeBinding

    private val repository: CoffeeRepository =
        CoffeeRepositoryImpl(CategoryMapper(), MachineMapper())

    override val currentTab: Int = R.id.products_menu

    override fun getBottomNavigation(): BottomNavigationView =
        binding.contentBottomNavigation.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCoffeeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        super.onCreate(savedInstanceState)
        setUpCapsuleList()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setUpCapsuleList() {
        CoroutineScope(Dispatchers.Main).launch {
            repository.getCoffees().let { categoryList ->
                val recyclerView = binding.rvCapsules

                recyclerView.addItemDecoration(
                    DividerItemDecoration(this@CoffeeActivity, DividerItemDecoration.VERTICAL)
                )

                val coffeeList = mutableListOf<Type>()

                categoryList.forEach {
                    coffeeList.add(it)
                    coffeeList.addAll(it.coffees)
                }

                recyclerView.adapter = CoffeAdapter(this@CoffeeActivity, coffeeList)
            }
        }
    }
}