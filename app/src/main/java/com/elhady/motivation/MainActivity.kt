package com.elhady.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Dataset
import androidx.recyclerview.widget.RecyclerView
import com.elhady.motivation.data.Datasource
import javax.sql.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadMotivation()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = ItemAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
    }
}