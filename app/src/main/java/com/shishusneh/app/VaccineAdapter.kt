package com.shishusneh.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shishusneh.app.database.Vaccine

class VaccineAdapter(
    private val vaccineList: List<Vaccine>,
    private val onLongClick: (Vaccine) -> Unit
) : RecyclerView.Adapter<VaccineAdapter.VaccineViewHolder>() {

    class VaccineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvVaccineItem: TextView = itemView.findViewById(R.id.tvVaccineItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vaccine, parent, false)
        return VaccineViewHolder(view)
    }

    override fun onBindViewHolder(holder: VaccineViewHolder, position: Int) {
        val vaccine = vaccineList[position]
        holder.tvVaccineItem.text = "${vaccine.vaccineName} - ${vaccine.vaccineDate}"

        holder.itemView.setOnLongClickListener {
            onLongClick(vaccine)
            true
        }
    }

    override fun getItemCount(): Int {
        return vaccineList.size
    }
}