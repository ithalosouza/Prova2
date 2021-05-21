package br.com.cotemig.Ithalo.services

import retrofit2.Call
import br.com.cotemig.Ithalo.models.Fatura
import retrofit2.http.GET

interface ServiceFatura {
    @GET("fatura")
    fun getFatura(): Call<List<Fatura>>
}