package com.example.registration

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var userLogin: EditText
    private lateinit var userEmail: EditText
    private lateinit var userPass: EditText
    private lateinit var registerButton: Button
    private lateinit var linkToAuth: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userLogin = view.findViewById(R.id.userLogin)
        userEmail = view.findViewById(R.id.userEmail)
        userPass = view.findViewById(R.id.userPass)
        registerButton = view.findViewById(R.id.buttonReg)
        linkToAuth = view.findViewById(R.id.linkToAuth)

        registerButton.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(requireContext(), "Заполните все поля для ввода", Toast.LENGTH_LONG).show()
            } else {
                val user = User(login, email, pass)
                val db = DbHelper(requireContext(), null)
                db.addUser(user)
                Toast.makeText(requireContext(), "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                // Очистить поля
                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
        linkToAuth.setOnClickListener {
            val intent = Intent(context, authActivity2::class.java)
            startActivity(intent)
        }
    }
}