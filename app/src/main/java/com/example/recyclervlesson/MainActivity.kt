package com.example.recyclervlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewlesson.Card
import com.example.recyclerviewlesson.CardAdapter
import com.example.recyclervlesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val adapter = CardAdapter()
    private val imageIdList = listOf(
        R.drawable.girl_01,
        R.drawable.girls_02,
        R.drawable.girls_03,
        R.drawable.girls_04,
        R.drawable.girls_05,
        R.drawable.girls_06,
        R.drawable.girls_07,
        R.drawable.girls_08,
        R.drawable.girls_09,
        R.drawable.girls_10,
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index > 9) index = 0
                val card = Card(imageIdList[index], "Card $index")
                adapter.addCard(card)
                index++
            }
        }
    }
}