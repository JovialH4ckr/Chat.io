package com.example.chatio.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.chatio.Utilities.EXTRA_LEAGUE
import com.example.chatio.R
import com.example.chatio.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        //println(league)
    }

    fun onbeginnerbtn(view: View){
        advancedbtn.isChecked = false
        skill = "beginner"
    }

    fun onadvancedbtn(view: View){
        beginnerbtn.isChecked = false
        skill = "advanced"
    }

    fun onscikkfinishclicked(view: View){
        if(skill !=""&& ((advancedbtn.isChecked == true)||(beginnerbtn.isChecked == true))) {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE,league)
            finishActivity.putExtra(EXTRA_SKILL,skill)
            startActivity(finishActivity)
        }
        else{
            Toast.makeText(this, getString(R.string.skilllevelselect), Toast.LENGTH_SHORT).show()
        }
    }
}
