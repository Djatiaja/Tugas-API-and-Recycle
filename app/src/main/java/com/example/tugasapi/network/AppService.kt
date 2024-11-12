package com.example.tugasapi.network

import com.example.tugasapi.model.JadwalSholat
import retrofit2.Call
import retrofit2.http.GET

interface AppService {
    @GET("semarang/2020/01.json")
    fun getAllJadwal(): Call<List<JadwalSholat>>
}
