package com.kaliostech.recyclerviewapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaliostech.recyclerviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binnding : ActivityMainBinding
    private var  data = mutableListOf<ItemsViewModel>()
    private lateinit var adapter: CustomAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binnding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binnding.root)

        binnding.addBtn.setOnClickListener {
            val text = binnding.editTextText.text.toString()
            data.add(ItemsViewModel(R.drawable.img, text))
            adapter.notifyDataSetChanged()
            binnding.editTextText.text.clear()

        }

        // this creates a vertical layout Manager
        binnding.rvMemories.layoutManager = LinearLayoutManager(this,)
        // This will pass the ArrayList to our Adapter
        adapter = CustomAdapter(data)
        // Setting the Adapter with the recyclerview
        binnding.rvMemories.adapter = adapter
    }
}