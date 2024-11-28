package com.enrique.pokedex

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.enrique.pokedex.database.dao.PokemonDAO
import com.enrique.pokedex.model.Pokemon
import com.enrique.pokedex.repository.PokemonService
import com.enrique.pokedex.ui.pokedex.PokedexViewModel
import io.mockk.*
import org.junit.*

class PokedexViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val dao: PokemonDAO = mockk(relaxed = true)
    private val service: PokemonService = mockk(relaxed = true)
    private lateinit var viewModel: PokedexViewModel

    @Before
    fun before() {
        viewModel = PokedexViewModel(dao, service)
    }

    @Test
    fun `GIVEN service WHEN call service THEN check if is called once at viewmodel initialization`() {
        verify(exactly = 1) { service.get() }
    }

    @Test
    fun `GIVEN mocked dao results WHEN get list of pokemons from view model THEN result as expected`() {
        // GIVEN
        val expected = listOf(
            Pokemon().apply { name = "Psyduck" },
            Pokemon().apply { name = "Onyx" }
        )
        every { dao.all() } returns MutableLiveData(expected)

        // WHEN
        val result = viewModel.getListPokemon()

        // THEN
        Assert.assertEquals(expected, result.value!!)
    }

    companion object {
        @JvmStatic
        @AfterClass
        fun tearDown() {
            unmockkAll()
        }
    }
}
