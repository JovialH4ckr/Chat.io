package com.example.chatio.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.chatio.Model.Player
import com.example.chatio.R
import com.example.chatio.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SkillActivity : BaseActivity() {

    lateinit var player: Player
    //var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
        //println(player.league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null) player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }

    fun onbeginnerbtn(view: View){
        advancedbtn.isChecked = false
        player.skill = getString(R.string.beginner)
    }

    fun onadvancedbtn(view: View){
        beginnerbtn.isChecked = false
        player.skill = getString(R.string.advanced)
    }

    fun onscikkfinishclicked(view: View){
        if(player.skill !=""&& ((advancedbtn.isChecked == true)||(beginnerbtn.isChecked == true))) {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER,player)
            startActivity(finishActivity)
        }
        else{
            Toast.makeText(this, getString(R.string.skilllevelselect), Toast.LENGTH_SHORT).show()
        }
    }
}
