package com.example.registration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class Item_Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item2)

        // Получаем данные из Intent
        val title = intent.getStringExtra("ItemTitle") ?: "Нет данных"
        val description = intent.getStringExtra("ItemDesc") ?: "Нет описания"
        val imageName = intent.getStringExtra("ItemImage")
        val ingredients = intent.getStringArrayListExtra("itemsList") ?: arrayListOf()

        // Пример данных для инструкций
        val instructions = arrayListOf(
            "Разогреть масло в казане",
            "Обжарить лук до золотистого цвета",
            "Добавить мясо и готовить 15 минут",
            "Добавить морковь, специи и тушить",
            "Добавить рис, воду и готовить под крышкой"
        )

        // Создаем и отображаем фрагмент
        val fragment = imageName?.let {
            ItemFragment.newInstance(title, description,
                it, ingredients, instructions)
        }
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (fragment != null) {
            transaction.replace(R.id.fragment_container, fragment)
        }
        transaction.commit()
    }
}