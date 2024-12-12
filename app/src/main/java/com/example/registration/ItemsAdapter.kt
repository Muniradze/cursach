package com.example.registration

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<item>, var context: Context): RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.itemListImage)
        val title: TextView = view.findViewById(R.id.itemListTitle)
        val desc: TextView = view.findViewById(R.id.itemListDesc)
        val btn: Button = view.findViewById(R.id.itemListButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.desc.text = items[position].desc

        var imageID = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageID)

        holder.btn.setOnClickListener{
            val itemsList = when (position) {
                0 -> arrayListOf("Рис (желательно длиннозерный) 500г", "Мясо (баранина, говядина или курица) 500г ", "Растительное масло 2-3ст.л.", "Лук (Большая луковица) 1шт", "Морковь 2-3шт", "Вода  4 стакана", "Чеснок 1-2 зубчика", "Соль по вкусу", "Специи (зира, черный перец, куркума) по вкусу")
                1 -> arrayListOf("Мясо (баранина или говядина) 500 г", "Вода 2-3 л", "Лук 1-2 шт", "Морковь 1-2 шт", "Картофель 2-3 шт", "Помидоры (или томатная паста) 1-2 шт", "Чеснок 2-3 зубчика", "Специи: зира, черный перец, лавровый лист — по вкусу", "Соль по вкусу")
                else -> arrayListOf("Слоёные лепёшки (можно обычные) 2-3 шт", "Вода 500 мл", "Курт или чакка (сушеное кислое молоко) 200 г", "Лук 1-2 шт", "Мясо (по желанию, баранина или говядина) 300 г", "Специи (черный перец, зира) по вкусу", "Масло растительное, для жарки")
            }
            val intent = Intent(context, Item_Activity2::class.java)
            intent.putStringArrayListExtra("ingredientsList", itemsList)
            context.startActivity(intent)

            intent.putExtra("ItemTitle", items[position].title)
            intent.putExtra("ItemDesc", items[position].desc)
            intent.putExtra("ItemText", items[position].ingredients)
            intent.putExtra("ItemTime", items[position].time)
            intent.putExtra("ItemImage", items[position].image)
            intent.putExtra("ItemInstruct", items[position].instruct)
            intent.putExtra("ItemInstructList", items[position].instructList)
            intent.putStringArrayListExtra("itemsList", itemsList)
            context.startActivity(intent)
        }
    }
}