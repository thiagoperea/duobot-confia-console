package api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RiotApiClient {

    fun getService(): RiotService {

        return Retrofit.Builder()
            .baseUrl("https://ddragon.leagueoflegends.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RiotService::class.java)
    }
}