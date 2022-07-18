package br.com.cwi.nespresso_app.presentation.products.machine

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.repostory.CoffeeRepositoryImpl
import br.com.cwi.nespresso_app.databinding.ActivityMachineBinding
import br.com.cwi.nespresso_app.presentation.base.BaseBottomNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MachineActivity : BaseBottomNavigation() {

    private lateinit var binding: ActivityMachineBinding

    private val repository = CoffeeRepositoryImpl(this)

    override val currentTab: Int = R.id.products_menu

    override fun getBottomNavigation(): BottomNavigationView =
        binding.contentBottomNavigation.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMachineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        super.onCreate(savedInstanceState)
        setUpMachineList()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setUpMachineList() {

        CoroutineScope(Dispatchers.Main).launch {

            repository.getMachines().let {
                val recyclerView = binding.rvMachines
                recyclerView.adapter = MachineAdapter(context = this@MachineActivity, it)
                recyclerView.layoutManager = GridLayoutManager(this@MachineActivity, 2)
            }
        }
    }
}