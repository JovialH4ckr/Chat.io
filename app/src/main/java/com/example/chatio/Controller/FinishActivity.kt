package com.example.chatio.Controller

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.chatio.Model.Player
import com.example.chatio.R
import com.example.chatio.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        SearchLeagueTxt.text = "Looking for ${player.league} ${player.skill} league near you..."
    }
}
