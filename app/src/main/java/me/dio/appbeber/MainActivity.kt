package me.dio.appbeber

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import me.dio.appbeber.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private lateinit var calcu: Calcular
    private var rest = 0.0

    lateinit var timePickerDialog: TimePickerDialog
    lateinit var calendario: Calendar
    lateinit var alarm: AlarmClock
    var horaAtual = 0
    var minutosAtuais = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        calcu = Calcular()

        binding.BT1.setOnClickListener {
            if (binding.P1.text.toString().isEmpty()) {
                Toast.makeText(this, "Informe o seu peso", Toast.LENGTH_SHORT).show()

            } else if (binding.I1.text.toString().isEmpty()) {
                Toast.makeText(this, "Informe a sua idade", Toast.LENGTH_SHORT).show()

            } else {
                val peso = binding.P1.text.toString().toDouble()
                val idade = binding.I1.text.toString().toInt()
                calcu.caulcularML(peso, idade)
                rest = calcu.res()
                val formatar = NumberFormat.getNumberInstance(Locale("pt", "BR"))
                formatar.isGroupingUsed = false
                binding.SM1.text = formatar.format(rest) + " " + "ml"
            }
        }


        binding.RE1.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(R.string.dialog_1)
                .setMessage(R.string.dialog_2)
                .setPositiveButton("OK", { dialogInterface, i ->
                    binding.P1.setText("")
                    binding.I1.setText("")
                    binding.SM1.text = ""
                })
            alertDialog.setNegativeButton("Cancelar", { dialogInterface, i ->

            })
            val dialog = alertDialog.create()
            dialog.show()
        }


        binding.BT2.setOnClickListener {
            calendario = Calendar.getInstance()
            horaAtual = calendario.get(Calendar.HOUR_OF_DAY)
            minutosAtuais = calendario.get(Calendar.MINUTE)
            timePickerDialog =
                TimePickerDialog(this, { timePicker: TimePicker, hourOfDay: Int, minutes: Int ->
                    binding.H1.text = String.format("%02d", hourOfDay)
                    binding.H3.text = String.format("%02d", minutes)
                }, horaAtual, minutosAtuais, true)
            timePickerDialog.show()
        }



    }
}