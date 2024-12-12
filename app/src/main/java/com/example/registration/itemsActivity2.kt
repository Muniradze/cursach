package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class itemsActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items2)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<item>()

        items.add(item(1, "plov", "Плов","Плов — это традиционное блюдо в кухнях Средней Азии и Ближнего Востока. Блюдо готовится часто в казане, и отличается богатым вкусом и ароматом благодаря различным специям.", "Время приготовления: 65 мин", "Ингредиенты:", "Способ приготовления:", ""))
        items.add(item(2, "shurpa", "Шурпа", "Шурпа — это наваристый суп, популярный в кухнях Центральной Азии. Блюдо имеет насыщенный вкус и аромат.", "Время приготовления: ", "Ингредиенты:", "Способ приготовления: 120 мин", ""))
        items.add(item(3, "kurutob", "Курутоб", "Курутоб — это традиционное блюдо, состоящее из хлебных крошек, смешанных с густым йогуртом (чакка), и с добавлением нарезанных овощей и зелени.", "Время приготовления: 30 мин ", "Ингредиенты:", "Способ приготовления:", ""))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)


        val bottomNavFragment = BottomNavFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottomNavContainer, bottomNavFragment)
            .commit()


    }
}