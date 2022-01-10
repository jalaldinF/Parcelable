package com.example.parcelable

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.provider.SyncStateContract
import com.example.parcelable.Data.Data
import kotlinx.android.synthetic.main.activity_reciever.*
import kotlin.String as String1

class Reciever : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reciever)

        setText()
        btn_send2.setOnClickListener(){
            val data = Data("badri",313)
            replay(data)

        }

    }
    fun setText(){
        val som = intent.getParcelableExtra<Data>("data_sent")
        val str = som?.name.toString() + " " + som?.age.toString()
            tv_just2.text = str

    }

    fun replay(data:Data){
      val intent = Intent()
      intent.putExtra("answer",data)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }

}