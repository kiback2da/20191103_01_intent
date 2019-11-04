package com.tjoeun.a20191103_01_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_user_info_acvity.*

class EditUserInfoAcvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user_info_acvity)

        cancelBtn.setOnClickListener {
            finish()
        }

        okBtn.setOnClickListener {
            var name = nameEdt.text
            var intent = Intent()

            intent.putExtra("inputName",nameEdt.text.toString())
            setResult(Activity.RESULT_OK,intent)

            finish()
        }


    }
}
