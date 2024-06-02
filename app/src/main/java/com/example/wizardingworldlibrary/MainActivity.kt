package com.example.wizardingworldlibrary

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaRouter.RouteCategory
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var showPop: ImageView
    private lateinit var gridLayout: GridLayout
    private lateinit var dropdown: AutoCompleteTextView
    private lateinit var favList: MutableList<String>

    private lateinit var hp1: ImageView
    private lateinit var hp2: ImageView
    private lateinit var hp3: ImageView
    private lateinit var hp4: ImageView
    private lateinit var hp5: ImageView
    private lateinit var hp6: ImageView
    private lateinit var hp7: ImageView
    private lateinit var hp8: ImageView
    private lateinit var fb1: ImageView
    private lateinit var fb2: ImageView
    private lateinit var fb3: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadData()

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showPop = findViewById(R.id.instructionButton)
        showPop.setOnClickListener{
            showPopup()
        }

        gridLayout = findViewById(R.id.gridView)
        dropdown = findViewById(R.id.dropdownMenu)

        hp1 = findViewById(R.id.hp1)
        hp1.setTag("hp1")

        hp2 = findViewById(R.id.hp2)
        hp2.setTag("hp2")

        hp3 = findViewById(R.id.hp3)
        hp3.setTag("hp3")

        hp4 = findViewById(R.id.hp4)
        hp4.setTag("hp4")

        hp5 = findViewById(R.id.hp5)
        hp5.setTag("hp5")

        hp6 = findViewById(R.id.hp6)
        hp6.setTag("hp6")

        hp7 = findViewById(R.id.hp7)
        hp7.setTag("hp7")

        hp8 = findViewById(R.id.hp8)
        hp8.setTag("hp8")

        fb1 = findViewById(R.id.fb1)
        fb1.setTag("fb1")

        fb2 = findViewById(R.id.fb2)
        fb2.setTag("fb2")

        fb3 = findViewById(R.id.fb3)
        fb3.setTag("fb3")

        val categories = resources.getStringArray(R.array.categories)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, categories)
        dropdown.setAdapter(adapter)

        dropdown.setOnItemClickListener { parent, view, position, id ->
            val selected = parent.getItemAtPosition(position).toString()
            handleCategorySelection(selected)
        }

        val buttonListener =View.OnClickListener { view ->
            val intent = Intent(this, ActivityBook::class.java)
            val tag: String = when (view.id) {
                R.id.hp1 -> "hp1"
                R.id.hp2 -> "hp2"
                R.id.hp3 -> "hp3"
                R.id.hp4 -> "hp4"
                R.id.hp5 -> "hp5"
                R.id.hp6 -> "hp6"
                R.id.hp7 -> "hp7"
                R.id.hp8 -> "hp8"
                R.id.fb1 -> "fb1"
                R.id.fb2 -> "fb2"
                R.id.fb3 -> "fb3"
                else -> ""
            }
            intent.putExtra("bookTag", tag)
            startActivity(intent)
        }

        hp1.setOnClickListener(buttonListener)
        hp2.setOnClickListener(buttonListener)
        hp3.setOnClickListener(buttonListener)
        hp4.setOnClickListener(buttonListener)
        hp5.setOnClickListener(buttonListener)
        hp6.setOnClickListener(buttonListener)
        hp7.setOnClickListener(buttonListener)
        hp8.setOnClickListener(buttonListener)
        fb1.setOnClickListener(buttonListener)
        fb2.setOnClickListener(buttonListener)
        fb3.setOnClickListener(buttonListener)
    }

    private fun handleCategorySelection(selected: String) {
        when (selected) {
            "All" -> showAll()
            "Harry Potter" -> showAllPotter()
            "Fantastic Beasts" -> showAllBeasts()
            "Favourites" -> showAllFavs()
        }
    }

    private fun showAll() {
        for (i in 0 until gridLayout.childCount) {
            val child = gridLayout.getChildAt(i)
            child.visibility = View.VISIBLE
        }
    }

    private fun hideItems() {
        for (i in 0 until gridLayout.childCount) {
            val child = gridLayout.getChildAt(i)
            child.visibility = View.GONE
        }
    }

    private fun showAllPotter() {
        hideItems()

        for (i in 0 until gridLayout.childCount) {
            val child = gridLayout.getChildAt(i)
            if (child is ImageView && child.id != View.NO_ID) {
                val sourceId = resources.getResourceEntryName(child.id)
                if (sourceId.startsWith("hp")) {
                    child.visibility = View.VISIBLE
                }
                else {
                    child.visibility = View.GONE
                }
            }
        }
    }

    private fun showAllBeasts() {
        hideItems()

        for (i in 0 until  gridLayout.childCount) {
            val child = gridLayout.getChildAt(i)
            if (child is ImageView && child.id != View.NO_ID) {
                val sourceId = resources.getResourceEntryName(child.id)
                if (sourceId.startsWith("fb")) {
                    child.visibility = View.VISIBLE
                }
                else {
                    child.visibility = View.GONE
                }
            }
        }
    }

    private fun showAllFavs() {
        hideItems()

        for (i in 0 until  gridLayout.childCount) {
            val child = gridLayout.getChildAt(i)
            if (child is ImageView && child.id != View.NO_ID) {
                val sourceId = resources.getResourceEntryName(child.id)
                if (sourceId in favList) {
                    child.visibility = View.VISIBLE
                }
                else {
                    child.visibility = View.GONE
                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        val file = File(this.filesDir, "list.txt")
        if (file.exists()) {
            val data = file.readText()
            favList = data.split("\n").filter { it.isNotEmpty() }.toMutableList()
        }
    }

    private fun showPopup() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.activity_info_popup, null)

        val width = 850
        val height = 1400

        val instructWindow = PopupWindow(popupView, width, height, true)
        instructWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        val closeButton = popupView.findViewById<ImageView>(R.id.closeButton)
        closeButton.setOnClickListener {
            instructWindow.dismiss()
        }
    }
}