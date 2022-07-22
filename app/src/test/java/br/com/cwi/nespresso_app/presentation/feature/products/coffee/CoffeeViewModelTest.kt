package br.com.cwi.nespresso_app.presentation.feature.products.coffee

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.cwi.nespresso_app.data.database.mapper.toEntity
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class CoffeeViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    private lateinit var viewModel: CoffeeViewModel

    private val coffeeRepository: CoffeeRepository = mockk()
    private val coffeeLocalRepository: CoffeeLocalRepository = mockk()

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = CoffeeViewModel(coffeeRepository, coffeeLocalRepository)
    }

    @Test
    fun givenCoffee_whenIsFavorite_thenSaveToLocalRepository() {
        // Arrange
        val coffee = Coffee(
            id = 1,
            name = "Café",
            urlImage = "",
            unitPrice = 1.0,
            description = "description",
            intensity = 10,
            measures = listOf("longo", "forte"),
            isFavorite = true
        )
        every { coffeeLocalRepository.add(coffee.toEntity()) } returns Unit

        // Act
        viewModel.setFavorite(coffee)

        // Assert
        verify { coffeeLocalRepository.add(coffee.toEntity()) }
    }

    @Test
    fun givenCoffee_whenIsNotFavorite_thenRemoveFromLocalRepository() {
        // Arrange
        val coffee = Coffee(
            id = 1,
            name = "Café",
            urlImage = "",
            unitPrice = 1.0,
            description = "description",
            intensity = 10,
            measures = listOf("longo", "forte"),
            isFavorite = false
        )
        every { coffeeLocalRepository.remove(coffee.toEntity()) } returns Unit

        // Act
        viewModel.setFavorite(coffee)

        // Assert
        verify { coffeeLocalRepository.remove(coffee.toEntity()) }
    }

    @Test
    fun whenFetchCoffees_thenReturnCoffeeSuccessfully() {
        // Arrange
        val coffeeObserver = viewModel.coffees.test()
        val categoryList = listOf(
            Category(
                category = "Category",
                products = emptyList(),
            )
        )
        coEvery { coffeeRepository.getCoffees() } returns categoryList
        coEvery { coffeeLocalRepository.getAll() } returns emptyList()

        // Act
        viewModel.fetchCoffees()

        // Assert
        verify { coffeeLocalRepository.getAll() }
        verify { coffeeObserver.onChanged(any()) }
    }
}

