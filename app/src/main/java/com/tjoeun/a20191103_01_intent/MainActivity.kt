package com.tjoeun.a20191103_01_intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_user_info_acvity.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_CODE_FOR_NAME = 1000
    val REQ_CODE_FOR_PHONENUM = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInputBtn.setOnClickListener {

            var intent = Intent(this,EditUserInfoAcvity::class.java)

            if(nameEdt.text.toString() != "이름 입력 필요"){
                intent.putExtra("userName",nameEdt.text.toString())
            }

            startActivityForResult(intent,REQ_CODE_FOR_NAME)

        }

        phoneNumInputBtn.setOnClickListener {
                var intent = Intent(this,EditPhoneActivity::class.java)
                startActivityForResult(intent,REQ_CODE_FOR_PHONENUM)
        }

        phoneDialBtn.setOnClickListener {
            var uri = Uri.parse("tel:01093686483") // 띄어쓰기 하면 안됨
            var intent = Intent(Intent.ACTION_DIAL,uri)
            startActivity(intent)
        }

        phoneCallBtn.setOnClickListener {
            /*var uri = Uri.parse("tel:01093686483") // 띄어쓰기 하면 안됨
            var intent = Intent(Intent.ACTION_CALL,uri)
            startActivity(intent)*/
        }

        smsBtn.setOnClickListener {
            var uri = Uri.parse("smsto:01093686483")
            var intent = Intent(Intent.ACTION_SENDTO,uri)

            intent.putExtra("sms_body","우리가 만든 앱입니다.")

            startActivity(intent)
        }

        webLinkBtn.setOnClickListener {
            var uri = Uri.parse("http://naver.com")
            var intent = Intent(Intent.ACTION_VIEW,uri)

            startActivity(intent)
        }

        storeBtn.setOnClickListener {
            var uri = Uri.parse("market://details?id=com.kakao.talk")
            var intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        mapBtn.setOnClickListener {
            var uri = Uri.parse("geo:37.123,127.567") //위도 값, 경도 값
            var intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQ_CODE_FOR_NAME){
            if(resultCode == Activity.RESULT_OK){

                var inputNameData = data?.getStringExtra("inputName")?.toLowerCase()

                //if(inputNameData != null) {  }
                inputNameData?.let {

                nameTxt.text = it

                var myName:String? = null
                }
            }
        }

        if(requestCode == REQ_CODE_FOR_PHONENUM) {
            if (resultCode == Activity.RESULT_OK) {
                var inputPhoneData = data?.getStringExtra("inputPhone")

                inputPhoneData?.let {
                    phoneNumTxt.text = it
                }
            }
        }
    }
}
