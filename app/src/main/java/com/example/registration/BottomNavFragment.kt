package com.example.registration

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class BottomNavFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Подключаем разметку фрагмента
        val view = inflater.inflate(R.layout.fragment_bottom_nav, container, false)

        // Находим кнопки
        val btnRegistration: Button = view.findViewById(R.id.btnRegistration)
        val btnRecipes: Button = view.findViewById(R.id.btnRecipes)
        val btnCart: Button = view.findViewById(R.id.btnCart)

        // Обработчики кнопок
        btnRegistration.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        btnRecipes.setOnClickListener {
            val intent = Intent(requireContext(), itemsActivity2::class.java)
            startActivity(intent)
        }

        btnCart.setOnClickListener {

//            val intent = Intent(requireContext(), CartFragment::class.java)
//            star

            val cartFragment = CartFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, cartFragment)
                .addToBackStack(null) // Для возврата назад
                .commit()
        }

        return view
    }

}