package com.example.assignmentweek5.UI.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.assignmentweek5.R
import com.example.assignmentweek5.UI.input.view.InputActivity
import com.example.assignmentweek5.UI.main.presenter.MainPresenter
import com.example.assignmentweek5.UI.main.presenter.MainView
import com.example.assignmentweek5.adapter.MahasiswaAdapter
import com.example.assignmentweek5.model.data.DataItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private var presenter : MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Mahasiswa App Mvp"

        fab.setOnClickListener {
            startActivity(Intent(this, InputActivity::class.java))
        }

        presenter = MainPresenter(this)
        presenter?.showData()
    }

    override fun onSuccess(msg: String, data: List<DataItem>?) {
        val adapter = MahasiswaAdapter(data, object : MahasiswaAdapter.OnItemClickCallback{

            override fun onItemClicked(item: DataItem?) {
                val intent = Intent(applicationContext, InputActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }

            override fun delete(item: DataItem?) {
                AlertDialog.Builder(this@MainActivity).apply {
                    setTitle("Hapus Data")
                    setMessage("Anda yakin ingin menghapus data ini?")
                    setPositiveButton("Hapus"){dialogInterface, i ->
                        presenter?.deleteData(item?.idMahasiswa ?: "")
                        dialogInterface.dismiss()
                    }
                    setNegativeButton("Batal") { dialogInterface, i ->
                        dialogInterface.dismiss()
                    }
                }.show()
            }
        })
        recycler_view.adapter = adapter
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onDelete(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


    override fun onResume() {
        super.onResume()
        presenter?.showData()
    }

}