package br.com.cwi.nespresso_app.di

import br.com.cwi.nespresso_app.presentation.feature.championdetail.ChampionDetailViewModel
import br.com.cwi.nespresso_app.presentation.feature.champions.ChampionViewModel
import br.com.cwi.nespresso_app.presentation.feature.inforanked.InfoRankedPlayerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { ChampionViewModel(get()) }
    viewModel { ChampionDetailViewModel(get()) }
    viewModel { InfoRankedPlayerViewModel(get()) }

}