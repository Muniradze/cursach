package com.example.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class AuthFragment : Fragment(R.layout.fragment_auth) {

    private lateinit var userLogin: EditText
    private lateinit var userPass: EditText
    private lateinit var authButton: Button
    private lateinit var linkToReg: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userLogin = view.findViewById(R.id.userLoginAuth)
        userPass = view.findViewById(R.id.userPassAuth)
        authButton = view.findViewById(R.id.buttonAuth)


        authButton.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login.isEmpty() || pass.isEmpty()) {
                Toast.makeText(requireContext(), "Заполните все поля для ввода", Toast.LENGTH_LONG).show()
            } else {
                val db = DbHelper(requireContext(), null)
                val isAuth = db.getUser(login, pass)

                if (isAuth) {
                    Toast.makeText(requireContext(), "Пользователь $login авторизован", Toast.LENGTH_LONG).show()
                    val intent = Intent(context, itemsActivity2::class.java)
                    startActivity(intent)
                    // Переход к следующему экрану
                } else {
                    Toast.makeText(requireContext(), "Пользователь $login НЕ авторизован", Toast.LENGTH_LONG).show()

                }
            }

        }
    }
}