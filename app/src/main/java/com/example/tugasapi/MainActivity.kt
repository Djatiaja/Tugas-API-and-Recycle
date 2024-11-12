package com.example.tugasapi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.restapi.network.ApiClient
import com.example.tugasapi.adapter.JadwalSholatAdapter
import com.example.tugasapi.databinding.ActivityMainBinding
import com.example.tugasapi.model.JadwalSholat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val responseJadwalSholat = client.getAllJadwal()

        responseJadwalSholat.enqueue(object : Callback<List<JadwalSholat>>{
            override fun onResponse(
                p0: Call<List<JadwalSholat>>,
                p1: Response<List<JadwalSholat>>
            ) {
                val dataSholat =p1.body()!!;
                var adapterJadwal = JadwalSholatAdapter(dataSholat)


                with(binding){
                    rvHolder.apply {
                        adapter= adapterJadwal
                        layoutManager =GridLayoutManager(this@MainActivity, 2)
                    }
                }

            }

            override fun onFailure(p0: Call<List<JadwalSholat>>, p1: Throwable) {
                Toast.makeText(this@MainActivity, "Internet error", Toast.LENGTH_SHORT).show()
            }

        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}