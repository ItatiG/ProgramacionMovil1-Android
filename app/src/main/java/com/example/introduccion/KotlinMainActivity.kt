package com.example.introduccion

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin_main.*

class KotlinMainActivity : AppCompatActivity() {

    //Primero la variable y después el tipo de dato
    //Operador de nulibilidad-> ?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)

        //Agregar un listener-> un objeto de otra clase
        //Agregar un listener-> un objeto de otra clase
        rgMoneda.setOnCheckedChangeListener { group, checkedId ->
            if (edtCantidad.text.toString().isEmpty())
            {
                edtCantidad.setText("1")
            }
            if (edtTipoCambio.text.toString().isEmpty())
            {
                edtTipoCambio.setText("1")
            }

            var dblCantidad = 0.0
            var dblTipoCambio = 0.0
            var dblResultado = 0.0

            dblCantidad = edtCantidad.text.toString().toDouble()
            dblTipoCambio = edtTipoCambio.text.toString().toDouble()

            when (checkedId)
            {
                R.id.rbPesoDolares ->
                {
                    dblResultado = dblCantidad / dblTipoCambio
                    ivBanderas.setImageResource(R.drawable.pesos_dolares)
                }
                else ->
                {
                    dblResultado = dblCantidad * dblTipoCambio
                    ivBanderas.setImageResource(R.drawable.dolares_pesos)
                }
            }
            tvResultado.text = "Resultado: $dblResultado"
        } //Se crea un objeto

        chkMostratImagen.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
            {
                ivBanderas.visibility = View.VISIBLE
            }
            else
            {
                ivBanderas.visibility = View.GONE
            }
        }
    }
        /*
        if (edtCantidad.text.toString().isEmpty())
        {
            edtCantidad.setText("0")
        }
        if (edtTipoCambio.text.toString().isEmpty())
        {
            edtTipoCambio.setText("0")
        }

        //Variables que almacenan los valores del EditText
        //No existen los tipos de datos primitivos, se declaran de un objeto de una clase
        var cantidad = edtCantidad.text.toString().toDouble() //Simula que se esta accediendo al atributo
        var tipoCambio = edtTipoCambio.text.toString().toDouble()
        var resultado = 0.0
        /*
        if (rbPesoDolares.isChecked)
        {
            resultado = cantidad / tipoCambio
        }
        if (rbDolaresPesos.isChecked)
        {
            resultado = cantidad * tipoCambio
        }
        */
        //Sintaxis de Kotlin-> Similar al switch
        resultado = when(rgMoneda.checkedRadioButtonId)
        {
            R.id.rbDolaresPesos -> cantidad * tipoCambio
            R.id.rbPesoDolares -> cantidad / tipoCambio

            else -> 0.0
        }
        /*
        if (rgMoneda.checkedRadioButtonId == R.id.rbPesoDolares)
        {
            resultado = cantidad / tipoCambio
        }
        else
        {
            resultado = cantidad * tipoCambio
        }
        */
        //resultado = cantidad * tipoCambio

        tvResultado.text = "El resultado es $${resultado}"
    }*/
}