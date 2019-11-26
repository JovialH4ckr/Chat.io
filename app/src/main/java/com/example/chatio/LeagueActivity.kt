package com.example.chatio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedleague = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onmensclicked(view: View){
        Womensbtn.isChecked = false
        Coedbtn.isChecked = false

        selectedleague="Mens"
    }

    fun onwomensclicked(view: View){
        Mensbtn.isChecked = false
        Coedbtn.isChecked = false

        selectedleague = "Womens"
    }
    fun oncoedclicked(view: View){
        Mensbtn.isChecked = false
        Womensbtn.isChecked = false

        selectedleague = "Co-ed"
    }

    fun leaguenextclicked(view: View){
        if (selectedleague != "" && ((Mensbtn.isChecked == true) || (Womensbtn.isChecked == true) || (Coedbtn.isChecked == true))) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedleague)
            startActivity(skillActivity)
        }
        else{
            Toast.makeText(this,"Please Select a League.",Toast.LENGTH_SHORT).show()
        }
    }
}
