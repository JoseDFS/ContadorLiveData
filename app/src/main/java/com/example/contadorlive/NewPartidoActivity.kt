package com.example.contadorlive

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil

import androidx.lifecycle.ViewModelProviders
import com.example.contadorlive.PartidoDB.PartidoEntity
import com.example.contadorlive.databinding.ActivityNewPartidoBinding
import kotlinx.android.synthetic.main.activity_new_partido.*
import kotlinx.android.synthetic.main.activity_partido.*
import java.text.SimpleDateFormat
import java.util.*


class NewPartidoActivity : AppCompatActivity() {

    lateinit var viewModel: PartidoViewModel

    var formate = SimpleDateFormat("dd MMM, yyyy", Locale.US)
    var timeFormat = SimpleDateFormat("hh:mm a", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_partido)
        val scoreViewModel = ViewModelProviders.of(this)
            .get(ScoreViewModel::class.java)

        DataBindingUtil.setContentView<ActivityNewPartidoBinding>(
            this, R.layout.activity_new_partido
        ).apply {
            this.setLifecycleOwner(this@NewPartidoActivity)
            this.score = scoreViewModel
        }

        bt_fecha.setOnClickListener {
            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.YEAR,year)
                selectedDate.set(Calendar.MONTH,month)
                selectedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                val date = formate.format(selectedDate.time)
                Toast.makeText(this,"date : " + date,Toast.LENGTH_SHORT).show()
                tv_fecha.text = formate.format(selectedDate.time)
            },
                now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }


        bt_hora.setOnClickListener {
            val now = Calendar.getInstance()
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                val selectedTime = Calendar.getInstance()
                selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                selectedTime.set(Calendar.MINUTE,minute)
                // btn_show.text = timeFormat.format(selectedTime.time)
                //val time = timeFormat.format(selectedTime.time)
                Toast.makeText(this,"time : " + timeFormat.format(selectedTime.time),Toast.LENGTH_SHORT).show()
                tv_hora.text = timeFormat.format(selectedTime.time)
            },
                now.get(Calendar.HOUR_OF_DAY),now.get(Calendar.MINUTE),false)
            timePicker.show()
        }
        viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        bt_guardar.setOnClickListener {
            if (TextUtils.isEmpty(et_1.text) && TextUtils.isEmpty(et_2.text)) {
                Toast.makeText(applicationContext, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                var partidoEntity = PartidoEntity(
                    0,
                    et_1.text.toString(),
                    et_2.text.toString()
                    ,
                    tv_score_team_a.text.toString().toInt(),
                    tv_score_team_b.text.toString().toInt(),
                    et_fecha.text.toString(),
                    et_hora.text.toString(),
                    ganador(
                        tv_score_team_a.text.toString(),
                        tv_score_team_b.text.toString()
                    )
                )
                viewModel.insert(partidoEntity)
                Log.d(
                    "InsertadoEnDB",
                    viewModel.allPartidos.toString()
                )
                Log.d("Hey", partidoEntity.toString())
                finish()
            }
        }




    }

    fun ganador(scoreA: String, scoreB: String): String {
        if (scoreA.toInt() > scoreB.toInt()) {
            return et_1!!.text.toString()
        }
        if(scoreA.toInt() < scoreB.toInt()) {return et_2!!.text.toString()}
        else
            return "Empate"

    }


}






