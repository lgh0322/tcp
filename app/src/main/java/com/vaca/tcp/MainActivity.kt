package com.vaca.tcp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(Intent(this, TcpClientService::class.java))
        } else {
            startService(Intent(this, TcpClientService::class.java))
        }
        val tt:TextView=findViewById(R.id.fuck)
        tt.setOnClickListener {
            Thread{
                TcpClientService.dataOutputStream!!.writeChars("fuckfuckfuck")
            }.start()
        }
    }
}