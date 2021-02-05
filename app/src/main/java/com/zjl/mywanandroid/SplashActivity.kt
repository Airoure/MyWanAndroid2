package com.zjl.mywanandroid

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.permissionx.guolindev.PermissionX
import com.zjl.mylibrary.base.BaseActivity
import java.util.*

class SplashActivity : BaseActivity() {
    override fun getLayout() = R.layout.activity_splash
    private var intentTask:Timer? = null
    override fun init(savedInstanceState: Bundle?) {
       PermissionX.init(this)
           .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
           .request { allGranted, grantedList, deniedList ->
               if(allGranted){
                   intentTask = Timer()
                   intentTask!!.schedule(object :TimerTask(){
                       override fun run() {
                           startIntent()
                       }
                   },2500)
               }else{

               }
           }
    }


    override fun onDestroy() {
        super.onDestroy()
        intentTask?.cancel()
    }

    private fun startIntent() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}