package com.example.tugasapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasapi.databinding.ItemJadwalBinding
import com.example.tugasapi.model.JadwalSholat

class JadwalSholatAdapter(
    private val ListJadwal:List<JadwalSholat>
): RecyclerView.Adapter<JadwalSholatAdapter.ItemJadwalSholat>() {
    inner class  ItemJadwalSholat(
        private val binding: ItemJadwalBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data: JadwalSholat) {
            with(binding) {
                textTanggal.text = "Tanggal: ${data.tanggal}"
                textImsyak.text = "Imsyak: ${data.imsyak}"
                textShubuh.text = "Shubuh: ${data.shubuh}"
                textTerbit.text = "Terbit: ${data.terbit}"
                textDhuha.text = "Dhuha: ${data.dhuha}"
                textDzuhur.text = "Dzuhur: ${data.dzuhur}"
                textAshr.text = "Ashr: ${data.ashr}"
                textMaghrib.text = "Maghrib: ${data.magrib}"
                textIsya.text = "Isya: ${data.isya}"
            }
        }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemJadwalSholat {
        val binding = ItemJadwalBinding.inflate(
            LayoutInflater.from(parent.context)
            , parent,false)
        return  ItemJadwalSholat(binding)
    }

    override fun getItemCount(): Int {
        return ListJadwal.size
    }

    override fun onBindViewHolder(holder: ItemJadwalSholat, position: Int) {
        holder.bind(ListJadwal[position])
    }
}