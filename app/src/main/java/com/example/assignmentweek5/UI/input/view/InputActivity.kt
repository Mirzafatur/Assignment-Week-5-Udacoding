package com.example.assignmentweek5.UI.input.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignmentweek5.R
import com.example.assignmentweek5.UI.input.presenter.InputPresenter
import com.example.assignmentweek5.UI.input.presenter.InputView
import com.example.assignmentweek5.model.action.ResponseAction
import com.example.assignmentweek5.model.data.DataItem
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity(), InputView {

    private var presenter : InputPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        supportActionBar?.title = "Input"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = InputPresenter(this)

        val data = intent.getParcelableExtra<DataItem>("data")
        if (data != null){
            edtNama.setText(data.mahasiswaNama)
            edtNohp.setText(data.mahasiswaNohp)
            edtAlamat.setText(data.mahasiswaAlamat)

            btnSimpan.text = "Update"
        }

        when(btnSimpan.text){
            "Update" ->{
                btnSimpan.setOnClickListener {
                    data?.idMahasiswa?.let { it1 -> presenter?.updateData(it1, edtNama.text.toString(), edtNohp.text.toString(), edtAlamat.text.toString()) }
                }
            }
            else -> {
                btnSimpan.setOnClickListener {
                    presenter?.inputData(edtNama.text.toString(), edtNohp.text.toString(), edtAlamat.text.toString())
                }
            }
        }

        btnBatal.setOnClickListener { finish() }
    }

    override fun onSuccessInput(response: ResponseAction) {
        toast("Data berhasil disimpan")
        finish()
    }

    override fun onError(msg: String) {
        toast(msg)
    }

    override fun onSuccessUpdate(response: ResponseAction) {
        toast("Data berhasil diupdate")
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun toast(msg : String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}