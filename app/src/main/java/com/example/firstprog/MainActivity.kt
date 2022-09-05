package com.example.firstprog

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var etName : EditText //declaration
    lateinit var tvMain: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //inflated -layoutinflater
        etName = findViewById(R.id.editTextTextPersonName)
        tvMain = findViewById(R.id.tvMain)
        Log.i(TAG,"im in oncreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: starting ui-visibe")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: Resuming-restore state")
    }
    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: Pausing- save state")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: stopping")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: destroying")
    }
    fun clickHandler(viewClicked: View) {
        // var name: String = etName.text.toString()
        Log.e(TAG,"click handler")
        when(viewClicked.id){
            R.id.btnLogin -> {startHomeActivity()}
            R.id.btnDial ->{startDialer()}
            R.id.btnAlarm -> {createAlarm("sync",12,56)}
        }

    }

    private fun startDialer() {
        var a = 10;
        var b = a * 20;

        add(10,20)
        for(i in 1..10)
        {
          var c= a * i
            var f = 30
            var z =  c + f
        }
        throw NullPointerException("dial ex")
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456"))
        startActivity(dIntent)
    }
    /**
     * This is called documentation
     * this method add's two number
     * @see https://github.com/abdultanveer/b2synchronous/commit/5dd82795ef415fb00097a5672ce4f1116f387e3a
     */
    private fun add(i: Int, i1: Int) {

    }


    private fun startHomeActivity() {
        Log.e(TAG, "click handler")
        var name = etName.text.toString()

        var hIntent = Intent(this, HomeActivity::class.java)//explicit intent
        //hIntent.putExtra("nkey", name)
        startActivityForResult(hIntent,123)
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    companion object{
        var TAG = MainActivity::class.java.simpleName
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, dIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, dIntent)
        var contactData = dIntent?.extras?.getString("con")
        tvMain.text = contactData
    }

}