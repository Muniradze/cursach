package com.example.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemFragment : Fragment() {
    companion object {
        fun newInstance(
            title: String,
            description: String,
            imageName: String?,
            ingredients: ArrayList<String>,
            instructions: ArrayList<String>
        ): ItemFragment {
            val fragment = ItemFragment()
            val args = Bundle()
            args.putString("title", title)
            args.putString("description", description)
            args.putString("imageName", imageName)
            args.putStringArrayList("ingredients", ingredients)
            args.putStringArrayList("instructions", instructions)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получение данных из аргументов
        val title = arguments?.getString("title") ?: "Нет данных"
        val description = arguments?.getString("description") ?: "Нет описания"
        val imageName = arguments?.getString("imageName")
        val ingredients = arguments?.getStringArrayList("ingredients") ?: arrayListOf()
        val instructions = arguments?.getStringArrayList("instructions") ?: arrayListOf()

        // Настройка TextView и ImageView
        val titleTextView: TextView = view.findViewById(R.id.itemListTitleOne)
        val descriptionTextView: TextView = view.findViewById(R.id.itemDescription)
        val imageView: ImageView = view.findViewById(R.id.itemImage)

        titleTextView.text = title
        descriptionTextView.text = description

        // Установка изображения
        imageName?.let {
            val imageId = resources.getIdentifier(it, "drawable", requireContext().packageName)
            if (imageId != 0) {
                imageView.setImageResource(imageId)
            }
        }

        // Настройка RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewIngredients)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = IngredientsAdapter(ingredients, requireContext())

        // Настройка RecyclerView для инструкций
        val recyclerViewInstructions: RecyclerView = view.findViewById(R.id.recyclerViewInstructions)
        recyclerViewInstructions.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewInstructions.adapter = InstructionsAdapter(instructions, requireContext())

    }
}