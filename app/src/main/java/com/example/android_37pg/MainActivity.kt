package com.example.android_37pg

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    private lateinit var chkAgree: SwitchCompat   // ★ CheckBox → SwitchCompat
    private lateinit var textView2: TextView
    private lateinit var rGroup1: RadioGroup
    private lateinit var imgPet: ImageView
    private lateinit var bottomButtons: LinearLayout
    private lateinit var btnReset: Button
    private lateinit var btnExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chkAgree = findViewById(R.id.chkAgree)
        textView2 = findViewById(R.id.textView2)
        rGroup1 = findViewById(R.id.rGroup1)
        imgPet = findViewById(R.id.imgPet)
        bottomButtons = findViewById(R.id.bottomButtons)
        btnReset = findViewById(R.id.btnReset)
        btnExit = findViewById(R.id.btnExit)

        setGroupVisible(chkAgree.isChecked)

        chkAgree.setOnCheckedChangeListener { _, isChecked ->
            setGroupVisible(isChecked)
        }

        rGroup1.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rdoDog -> showImage(R.drawable.oreo)
                R.id.rdoCat -> showImage(R.drawable.pie)
                R.id.rdoRabbit -> showImage(R.drawable.q10)
                else -> {
                    imgPet.visibility = View.INVISIBLE
                    imgPet.setImageDrawable(null)
                }
            }
        }

        btnReset.setOnClickListener {
            chkAgree.isChecked = false
            rGroup1.clearCheck()
            imgPet.setImageDrawable(null)
            setGroupVisible(false)
        }

        btnExit.setOnClickListener { finish() }
    }

    private fun showImage(resId: Int) {
        imgPet.setImageResource(resId)
        imgPet.visibility = View.VISIBLE
    }

    private fun setGroupVisible(visible: Boolean) {
        val vis = if (visible) View.VISIBLE else View.INVISIBLE
        textView2.visibility = vis
        rGroup1.visibility = vis
        bottomButtons.visibility = vis

        if (!visible) {
            imgPet.visibility = View.INVISIBLE
        } else if (rGroup1.checkedRadioButtonId != -1) {
            imgPet.visibility = View.VISIBLE
        }
    }
}
