package br.com.cwi.nespresso_app.data.network.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitConfig {

    val service: LeagueApi = Retrofit.Builder()
        .baseUrl("http://192.168.1.3:3000/")
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()
        .create(LeagueApi::class.java)

    val serviceRanked: RankedApi = Retrofit.Builder()
        .baseUrl("https://br1.api.riotgames.com/lol/")
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()
        .create(RankedApi::class.java)
}