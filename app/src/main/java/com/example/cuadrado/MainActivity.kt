package com.example.cuadrado

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Cuadrado

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rectanguloView: View =findViewById(R.id.view)
        val btnArriba: Button=findViewById(R.id.btnArriba)
        val btnAbajo: Button=findViewById(R.id.btnAbajo)
        val btnDerecha: Button=findViewById(R.id.btnDerecha)
        val btnIzquierda: Button=findViewById(R.id.btnIzquierda)
        val btnCambiarColor: Button=findViewById(R.id.btnCambiarColor)
        val btnCambiarTama: Button=findViewById(R.id.btnCambiarTama)
        var cuadrado:Cuadrado=Cuadrado(ContextCompat.getColor(this, R.color.red), 100, 100, rectanguloView.x, rectanguloView.y)
        Log.i("Cuadrado: ", cuadrado.x.toString())

        btnCambiarColor.setOnClickListener {

            cuadrado.cambiarColor(R.color.blue)
            refrescarInterfaz(cuadrado, rectanguloView)
        }

        btnArriba.setOnClickListener {
            Log.i("Cuadrado: ", cuadrado.x.toString())
            cuadrado.moverArriba()
            refrescarInterfaz(cuadrado, rectanguloView)
        }
        btnAbajo.setOnClickListener {
            cuadrado.moverAbajo()
            refrescarInterfaz(cuadrado, rectanguloView)
        }
        btnDerecha.setOnClickListener {
            cuadrado.moverDerecha()
            refrescarInterfaz(cuadrado, rectanguloView)
        }
        btnIzquierda.setOnClickListener {
            cuadrado.moverIzquierda()
            refrescarInterfaz(cuadrado, rectanguloView)
        }

        btnCambiarTama.setOnClickListener {

            cuadrado.cambiarTamano(150, 150)
            refrescarInterfaz(cuadrado, rectanguloView)
        }
    }

    private fun refrescarInterfaz(cuadrado:Cuadrado, cuadradoView:View){
        cuadradoView.layoutParams.width=cuadrado.ancho
        cuadradoView.layoutParams.height=cuadrado.alto
        cuadradoView.setBackgroundColor(cuadrado.color)
        cuadradoView.x=cuadrado.x.toFloat()
        cuadradoView.y= cuadrado.y.toFloat()
        cuadradoView.requestLayout()
    }
}