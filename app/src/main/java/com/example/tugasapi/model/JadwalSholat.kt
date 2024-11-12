package com.example.tugasapi.model

import com.google.gson.annotations.SerializedName

data class JadwalSholat(
    @SerializedName("imsyak")
        val imsyak: String,
    @SerializedName("shubuh")
        val shubuh: String,
    @SerializedName("dzuhur")
        val dzuhur: String,
    @SerializedName("tanggal")
        val tanggal: String,
    @SerializedName("terbit")
        val terbit: String,
    @SerializedName("magrib")
        val magrib: String,
    @SerializedName("isya")
        val isya: String,
    @SerializedName("dhuha")
        val dhuha: String,
    @SerializedName("ashr")
        val ashr: String
)

