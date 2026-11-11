package com.proyectoaet1.login_y_cardview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.proyectoaet1.login_y_cardview.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    //Componentes con ViewBinding
    private lateinit var loginBinding: ActivityLoginBinding;

    /*
    Constantes con el usuario y la contraseña correctos. Con estos dos valores
    comparamos lo que escribe el usuario al pulsar el boton Validar
     */

    private val MYUSER = "admin";
    private val MYPASS = "1234";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflamos las vistas
        loginBinding = ActivityLoginBinding.inflate(layoutInflater);
        setContentView(loginBinding.root);

        /*
        Boton Validar Guardamos lo que ha escrito el usuario (quitando los espacios
        del principio y del final con trim) y lo comparamos con MYUSER y MYPASS
         */

        loginBinding.buttonLoginValidar.setOnClickListener {

            val usuario = loginBinding.editTextLoginUsuario.text.toString().trim();
            val password = loginBinding.editTextLoginPassword.text.toString().trim();

            if (usuario == MYUSER && password == MYPASS) {

                //Validacion correcta Intent explicito hacia CardViewActivity
                //y le pasamos el usuario y la contraseña con putExtra

                val intent = Intent(this, CardViewActivity::class.java);
                intent.putExtra("extra_usuario", usuario);
                intent.putExtra("extra_password", password);

                //Con estos flags evitamos duplicar pantallas: si la Activity ya
                //estaba abierta se reutiliza en vez de crear otra encima
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);

            } else {

                //Validacion incorrecta avisamos con un Toast

                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();

            }
        }

    }
}