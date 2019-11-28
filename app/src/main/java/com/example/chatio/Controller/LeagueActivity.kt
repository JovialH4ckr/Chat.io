package com.example.chatio.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.chatio.Model.Player
import com.example.chatio.R
import com.example.chatio.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    //var selectedleague = ""
    var player = Player("","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onmensclicked(view: View){
        Womensbtn.isChecked = false
        Coedbtn.isChecked = false

        player.league = getString(R.string.mens)
    }

    fun onwomensclicked(view: View){
        Mensbtn.isChecked = false
        Coedbtn.isChecked = false

        player.league = getString(R.string.womens)
    }
    fun oncoedclicked(view: View){
        Mensbtn.isChecked = false
        Womensbtn.isChecked = false

        player.league = getString(R.string.co_ed)
    }

    fun leaguenextclicked(view: View){
        if (player.league != "" && ((Mensbtn.isChecked == true) || (Womensbtn.isChecked == true) || (Coedbtn.isChecked == true))) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        }
        else{
            Toast.makeText(this,getString(R.string.leagueselect),Toast.LENGTH_SHORT).show()
        }
    }
}
