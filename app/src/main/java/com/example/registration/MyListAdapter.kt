package com.example.registration

import android.content.Context
import android.widget.ArrayAdapter

class MyListAdapter(context: Context, private val items: List<String>): ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, items) {
}