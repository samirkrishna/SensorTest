package com.hasini.samirkrishna.sensortest

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var tv1:TextView?=null
    var tv2:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1=findViewById(R.id.tv1)
        tv2=findViewById(R.id.tv2)
        var sManager:SensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        var s:Sensor=sManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        sManager.registerListener(object : SensorEventListener {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

            override fun onSensorChanged(event: SensorEvent?) {

                val values=event?.values
                tv1?.text=values?.get(0).toString()
              // tv2?.text=values?.get(1).toString()
            }
        },s,SensorManager.SENSOR_DELAY_NORMAL)
    }
}
