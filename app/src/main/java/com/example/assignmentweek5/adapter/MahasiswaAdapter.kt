package com.example.assignmentweek5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentweek5.R
import com.example.assignmentweek5.UI.main.presenter.MainView
import com.example.assignmentweek5.model.data.DataItem
import kotlinx.android.synthetic.main.list_item.view.*

class MahasiswaAdapter(var data : List<DataItem>?, var onItemClickCallback : OnItemClickCallback ) : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {


    class MahasiswaViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val nama = itemView.tvNamaMahasiswa
        val nohp = itemView.tvNohpMahasiswa
        val alamat = itemView.tvAlamatMahasiswa
        val btnHapus = itemView.btnDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {

        val item = data?.get(position)

        holder.nama.text = item?.mahasiswaNama
        holder.nohp.text = item?.mahasiswaNohp
        holder.alamat.text = item?.mahasiswaAlamat

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(item)
        }

        holder.btnHapus.setOnClickListener{
            onItemClickCallback.delete(item)
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(item: DataItem?)
        fun delete(item : DataItem?)
    }

}