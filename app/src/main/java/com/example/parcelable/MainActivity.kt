package com.example.parcelable

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.parcelable.Data.Data
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_reciever.*

class MainActivity : AppCompatActivity() {
    val DETAIL_CODE = 313
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          initView()

        }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== RESULT_OK){
         var str= data?.getParcelableExtra<Data>("answer")
           tv_just.text = str?.name.toString() + " " + str?.age.toString()
        }

    }

        fun initView(){
            btn_send.setOnClickListener(){
                val data = Data("Jalal ad-Addin",25)
                sendData(data)
        }
    }
    fun sendData(data: Data){

        val intent = Intent(this,Reciever::class.java)
        intent.putExtra("data_sent",data)
        startActivityForResult(intent,DETAIL_CODE)
    }
}
