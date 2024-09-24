package com.example.recyclerviewzidan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var personAdapter: PersonAdapter
    private lateinit var personList: MutableList<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personList = mutableListOf(
            Person("Bayu", 25),
            Person("Dani", 30),
            Person("Siti", 22)
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        personAdapter = PersonAdapter(personList)
        recyclerView.adapter = personAdapter

        val nameInput: EditText = findViewById(R.id.nameInput)
        val ageInput: EditText = findViewById(R.id.ageInput)
        val addButton: Button = findViewById(R.id.addButton)

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val ageText = ageInput.text.toString()

            if (name.isBlank() || ageText.isBlank()) {
                Toast.makeText(this, "Please enter both name and age", Toast.LENGTH_SHORT).show()
            } else {
                val age = ageText.toInt()
                val newPerson = Person(name, age)
                personList.add(newPerson)
                personAdapter.notifyItemInserted(personList.size - 1)

                nameInput.text.clear()
                ageInput.text.clear()
            }
        }
    }
}
