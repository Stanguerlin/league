package br.com.cwi.nespresso_app.di

import br.com.cwi.nespresso_app.data.network.remote.RetrofitConfig
import br.com.cwi.nespresso_app.data.repository.ChampionRepositoryImpl
import br.com.cwi.nespresso_app.data.repository.InfoRankedRepositoryImpl
import br.com.cwi.nespresso_app.domain.repository.ChampionRepository
import br.com.cwi.nespresso_app.domain.repository.InfoRankedRepository
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }
    single { RetrofitConfig.serviceRanked }


    factory<ChampionRepository> { ChampionRepositoryImpl(get()) }
    factory<InfoRankedRepository> { InfoRankedRepositoryImpl(get()) }

}