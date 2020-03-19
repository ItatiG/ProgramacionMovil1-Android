package com.example.introduccion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class KotlinMain2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main2)

        //Mediante un listener
        //btnConversorMoneda.setOnClickListener
    }

    fun ConversorMoneda(view: View)
    {
        //Intent explícita
        //Para crear un nuevo objeto no se usa new- Solo se mandaa llamar al constructor
        startActivity(Intent(this, KotlinMainActivity::class.java))//this hace referencia a KotlinMain2Activity
        //startActivity solo recibe una Intent
    }

    fun EnviarMensaje(view: View)
    {
        val textMessage = ""

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, textMessage)
            type = "text/plain"
        }

        if (sendIntent.resolveActivity(packageManager) != null)
        {
            startActivity(sendIntent)
        }
    }

    fun MostrarMapa(view: View)
    {
        val gmmIntentUri: Uri = Uri.parse("geo:27.49551,-99.4948466,18.68?z=15")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        if (mapIntent.resolveActivity(packageManager) != null)
        {
            startActivity(mapIntent)
        }
    }

    //Asignar un menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main2, menu)
        return true
    }

    //Cuando se da clic sobre uno de los items
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        // Handle item selection
        //Switch
        return when (item.itemId)
        {
            R.id.kmoneda ->
            {
                //Se manda a llamar a la Activity
                startActivity(Intent(this, KotlinMainActivity::class.java))//this hace referencia a KotlinMain2Activity
                true
            }
            R.id.jmoneda ->
            {
                startActivity(Intent(this, MainActivity::class.java))//this hace referencia a KotlinMain2Activity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
