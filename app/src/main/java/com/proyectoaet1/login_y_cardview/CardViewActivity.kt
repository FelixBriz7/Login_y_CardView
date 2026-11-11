package com.proyectoaet1.login_y_cardview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.proyectoaet1.login_y_cardview.databinding.ActivityCardViewBinding

class CardViewActivity : AppCompatActivity() {

    //Componentes con ViewBinding
    private lateinit var cardViewBinding: ActivityCardViewBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflamos las vistas
        cardViewBinding = ActivityCardViewBinding.inflate(layoutInflater);
        setContentView(cardViewBinding.root);

        /*
        Recuperamos la información que nos manda LoginActivity con el Intent.
        Las claves "extra_usuario" y "extra_password" son las mismas que pusimos
        en los putExtra del LoginActivity
         */

        val usuario = intent.getStringExtra("extra_usuario");
        val password = intent.getStringExtra("extra_password");

        //Mostramos los datos recibidos en la pantalla

        cardViewBinding.textViewCardViewBienvenida.text = "Bienvenido, $usuario";
        cardViewBinding.textViewCardViewUsuario.text = "Usuario: $usuario";
        cardViewBinding.textViewCardViewPassword.text = "Contraseña: $password";

    }
}