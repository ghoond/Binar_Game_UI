package com.example.binar_game_gbk_with_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnBatu: ImageView
    private lateinit var btnGunting: ImageView
    private lateinit var btnKertas: ImageView
    private lateinit var comBatu: ImageView
    private lateinit var comGunting: ImageView
    private lateinit var comKertas: ImageView

    private lateinit var hasil: TextView
    private lateinit var btnRestart: ImageView

    private var choice: List<String> = listOf("Batu", "Gunting", "Kertas")

    private var selected: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hasil = findViewById(R.id.hasil)

        btnRestart = findViewById(R.id.reset)
        btnRestart.setOnClickListener(this)

        btnKertas = findViewById(R.id.player_kertas)
        btnKertas.setOnClickListener(this)

        btnBatu = findViewById(R.id.player_batu)
        btnBatu.setOnClickListener(this)

        btnGunting = findViewById(R.id.player_gunting)
        btnGunting.setOnClickListener(this)

        comKertas = findViewById(R.id.com_kertas)
        comBatu = findViewById(R.id.com_batu)
        comGunting = findViewById(R.id.com_gunting)
    }

    private fun matching(playerOne: String, computer: String) {
        if (playerOne.lowercase() == computer.lowercase()) {
            hasil.setText("Seri Bos Main Lagi!")
        } else if (playerOne.lowercase() == "batu") {
            if (computer.lowercase() == "gunting") {
                hasil.setText("Pemain 1 MENANG!")
            } else {
                hasil.setText("Komputer MENANG!")
            }
        } else if (playerOne.lowercase() == "gunting") {
            if (computer.lowercase() == "kertas") {
                hasil.setText("Pemain 1 MENANG!")
            } else {
                hasil.setText("Komputer MENANG!")
            }
        } else if (playerOne.lowercase() == "kertas") {
            if (computer.lowercase() == "batu") {
                hasil.setText("Pemain 1 MENANG!")
            } else {
                hasil.setText("Komputer MENANG!")
            }
        }
    }

    override fun onClick(v: View?) {
        val size = choice.size - 1
        val randomIndex = (0..size).random()
        val computerSelected: String = choice[randomIndex]

        when (v?.id) {
            R.id.player_batu -> {
                selected = "Batu"
                btnBatu.setBackgroundResource(R.drawable.bg_icon)
                btnKertas.setBackgroundColor(android.R.color.transparent)
                btnGunting.setBackgroundColor(android.R.color.transparent)
                when (randomIndex) {
                    0 -> {
                        comBatu.setBackgroundResource(R.drawable.bg_icon)
                        comKertas.setBackgroundColor(android.R.color.transparent)
                        comGunting.setBackgroundColor(android.R.color.transparent)
                    }
                    1 -> {
                        comGunting.setBackgroundResource(R.drawable.bg_icon)
                        comKertas.setBackgroundColor(android.R.color.transparent)
                        comBatu.setBackgroundColor(android.R.color.transparent)
                    }
                    else -> {
                        comKertas.setBackgroundResource(R.drawable.bg_icon)
                        comGunting.setBackgroundColor(android.R.color.transparent)
                        comBatu.setBackgroundColor(android.R.color.transparent)
                    }
                }
                matching(selected, computerSelected)
                btnBatu.setEnabled(false);
                btnKertas.setEnabled(false);
                btnGunting.setEnabled(false);
            }
            R.id.player_gunting -> {
                selected = "Gunting"
                btnGunting.setBackgroundResource(R.drawable.bg_icon)
                btnBatu.setBackgroundColor(android.R.color.transparent)
                btnKertas.setBackgroundColor(android.R.color.transparent)
                when (randomIndex) {
                    0 -> {
                        comBatu.setBackgroundResource(R.drawable.bg_icon)
                        comKertas.setBackgroundColor(android.R.color.transparent)
                        comGunting.setBackgroundColor(android.R.color.transparent)
                    }
                    1 -> {
                        comGunting.setBackgroundResource(R.drawable.bg_icon)
                        comKertas.setBackgroundColor(android.R.color.transparent)
                        comBatu.setBackgroundColor(android.R.color.transparent)
                    }
                    else -> {
                        comKertas.setBackgroundResource(R.drawable.bg_icon)
                        comGunting.setBackgroundColor(android.R.color.transparent)
                        comBatu.setBackgroundColor(android.R.color.transparent)
                    }
                }
                matching(selected, computerSelected)
                btnBatu.setEnabled(false);
                btnKertas.setEnabled(false);
                btnGunting.setEnabled(false);
            }
            R.id.player_kertas -> {
                selected = "Kertas"
                btnKertas.setBackgroundResource(R.drawable.bg_icon)
                btnGunting.setBackgroundColor(android.R.color.transparent)
                btnBatu.setBackgroundColor(android.R.color.transparent)
                when (randomIndex) {
                    0 -> {
                        comBatu.setBackgroundResource(R.drawable.bg_icon)
                        comKertas.setBackgroundColor(android.R.color.transparent)
                        comGunting.setBackgroundColor(android.R.color.transparent)
                    }
                    1 -> {
                        comGunting.setBackgroundResource(R.drawable.bg_icon)
                        comKertas.setBackgroundColor(android.R.color.transparent)
                        comBatu.setBackgroundColor(android.R.color.transparent)
                    }
                    else -> {
                        comKertas.setBackgroundResource(R.drawable.bg_icon)
                        comGunting.setBackgroundColor(android.R.color.transparent)
                        comBatu.setBackgroundColor(android.R.color.transparent)
                    }
                }
                matching(selected, computerSelected)
                btnBatu.setEnabled(false);
                btnKertas.setEnabled(false);
                btnGunting.setEnabled(false);
            }
            R.id.reset -> {
                btnBatu.setBackgroundColor(android.R.color.transparent)
                btnKertas.setBackgroundColor(android.R.color.transparent)
                btnGunting.setBackgroundColor(android.R.color.transparent)
                comBatu.setBackgroundColor(android.R.color.transparent)
                comKertas.setBackgroundColor(android.R.color.transparent)
                comGunting.setBackgroundColor(android.R.color.transparent)
                hasil.setText("VS")
                btnBatu.setEnabled(true);
                btnKertas.setEnabled(true);
                btnGunting.setEnabled(true);
            }
        }
    }
}