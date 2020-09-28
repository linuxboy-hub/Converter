package com.linuxboy.converte

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val origen_list = resources.getStringArray(R.array.origen)
        val destino_list = resources.getStringArray(R.array.destino)


        convert_button.setOnClickListener {
            val valor = valor_in.text.toString()
            val origen = in_spinner.selectedItem.toString()
            val destino = out_spinner.selectedItem.toString()


            if (valor_in.text.toString().isEmpty()){
                result_text_view.text = "Ingrese el VALOR a convertir"
                return@setOnClickListener
            }
            if (in_spinner.selectedItem == origen_list.get(0)){
                result_text_view.text = "Ingrese el ORIGEN del valor"
                return@setOnClickListener
            }

            if (out_spinner.selectedItem == destino_list.get(0)){
                result_text_view.text = "Ingrese el DESTINO del valor"
                return@setOnClickListener
            }

            val conv = if (origen == "USD"){
                            if (destino == "COP"){
                                valor.toFloat()*3827.65
                            }else if (destino == "EUR"){
                                valor.toFloat()*0.86
                            }else if (destino == "MXN"){
                                valor.toFloat()*21.78
                            }else{
                                valor.toFloat()*1
                            }
                        }else if (origen == "COP"){
                            if (destino == "USD"){
                                valor.toFloat()*0.00026
                            }else if (destino == "EUR"){
                                valor.toFloat()*0.00022
                            }else if (destino == "MXN"){
                                valor.toFloat()*0.0057
                            }else{
                                valor.toFloat()*1
                            }
                        }else if (origen == "EUR"){
                            if (destino == "USD"){
                                valor.toFloat()*1.17
                            }else if (destino == "COP"){
                                valor.toFloat()*4470.62
                            }else if (destino == "MXN"){
                                valor.toFloat()*25.43
                            }else{
                                valor.toFloat()*1
                            }
                        }else if (origen == "MXN"){
                            if (destino == "USD"){
                                valor.toFloat()*0.046
                            }else if (destino == "COP"){
                                valor.toFloat()*175.79
                            }else if (destino == "EUR"){
                                valor.toFloat()*0.039
                            }else{
                                valor.toFloat()*1
                            }
                        }else{
                valor.toFloat()*0
                        }


            result_text_view.text = getString(R.string.resultado, valor, origen, conv.toString(), destino)
        }
    }
}