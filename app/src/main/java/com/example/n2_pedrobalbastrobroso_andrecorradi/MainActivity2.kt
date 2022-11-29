package com.example.n2_pedrobalbastrobroso_andrecorradi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity(),View.OnClickListener {
    var txtN1: TextView?=null
    var txtN2: TextView?=null
    var txtMedia: TextView?=null
    var media:Double=0.0
    var situacao:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = intent
        val text = intent.getStringExtra("email")
        emailview.text = text.toString()

        txtN1 = findViewById<TextView>(R.id.inputN1)
        txtN2 = findViewById<TextView>(R.id.inputN2)
        txtMedia = findViewById<TextView>(R.id.txtMedia)
        val botao5: Button = findViewById<Button>(R.id.button5)
        botao5.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (validarForm(txtN1 as TextView,txtN2 as TextView)) {
            media = (txtN1?.text.toString().toDouble()
                    + txtN2?.text.toString().toDouble()) / 2
            txtMedia?.text = media.toString()
            if (media >= 6.0) {
                situacao = "Aprovado"
            } else if (media >= 4) {
                situacao = "Exame"
            } else {
                situacao = "Reprovado"
            }
            Toast.makeText(this, situacao, Toast.LENGTH_LONG).show()
        }
    }
    private  fun validarForm(txtV1:TextView,txtV2:TextView,):Boolean{
        var valido=true
        if (TextUtils.isEmpty(txtV1.text.toString())){
            txtV1.error="Campo obrigatorio"
            valido= false
        }else if (txtV1.text.toString().toDouble()>10){
            txtV1.error= "valor maior que 10"
            valido= false
        }
        if (TextUtils.isEmpty(txtV2.text.toString())){
            txtV2.error="Campo obrigatorio"
            valido= false
        }else if (txtV2.text.toString().toDouble()>10){
            txtV2.error= "valor maior que 10"
            valido= false
        }
        return valido
    }
}