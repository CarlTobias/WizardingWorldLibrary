package com.example.wizardingworldlibrary

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityBook : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences

    private lateinit var backButton: ImageView

    private lateinit var hpfbText: TextView
    private lateinit var storyTitle: TextView
    private lateinit var synopsisText: TextView

    private lateinit var imageOne: ImageView
    private lateinit var imageTwo: ImageView
    private lateinit var imageThree: ImageView
    private lateinit var imageFour: ImageView
    private lateinit var imageFive: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        backButton = findViewById(R.id.backButton)

        hpfbText = findViewById(R.id.hpfbText)
        storyTitle = findViewById(R.id.storyTitle)
        synopsisText = findViewById(R.id.synopsisText)

        imageOne = findViewById(R.id.imageOne)
        imageTwo = findViewById(R.id.imageTwo)
        imageThree = findViewById(R.id.imageThree)
        imageFour = findViewById(R.id.imageFour)
        imageFive = findViewById(R.id.imageFive)

        val buttonListener = View.OnClickListener { view ->
            finish()
        }

        backButton.setOnClickListener(buttonListener)

        val bookTag = intent.getStringExtra("bookTag")
        if (bookTag == "hp1") {
            storyTitle.text = "and the Philosopher's Stone"
            synopsisText.text = "The book is about 11 year old Harry Potter, who receives a letter saying that he is invited to attend Hogwarts, school of witchcraft and wizardry. He then learns that a powerful wizard and his minions are after the sorcerer’s stone that will make this evil wizard immortal and undefeatable."

            imageOne.setImageResource(R.drawable.hp1a)
            imageOne.setTag("hp1a")

            imageTwo.setImageResource(R.drawable.hp1b)
            imageTwo.setTag("hp1b")

            imageThree.setImageResource(R.drawable.hp1c)
            imageThree.setTag("hp1c")

            imageFour.setImageResource(R.drawable.hp1d)
            imageFour.setTag("hp1d")

            imageFive.setImageResource(R.drawable.hp1e)
            imageFive.setTag("hp1e")
        }

        else if (bookTag == "hp2") {
            storyTitle.text = "and the Chamber of Secrets"
            synopsisText.text = "When the Chamber of Secrets is opened again at the HogwartsSchool for Witchcraft and Wizardry, second-year student Harry Potter finds himself in danger from a dark power that has once more been released on the school."

            imageOne.setImageResource(R.drawable.hp2a)
            imageOne.setTag("hp2a")

            imageTwo.setImageResource(R.drawable.hp2b)
            imageTwo.setTag("hp2b")

            imageThree.setImageResource(R.drawable.hp2c)
            imageThree.setTag("hp2c")

            imageFour.setImageResource(R.drawable.hp2d)
            imageFour.setTag("hp2d")

            imageFive.setImageResource(R.drawable.hp2e)
            imageFive.setTag("hp2e")
        }

        else if (bookTag == "hp3") {
            storyTitle.text = "and the Prisoner of Azkaban"
            synopsisText.text = "For twelve years, the dread fortress of Azkaban held an infamous prisoner named Sirius Black. Convicted of killing thirteen people with a single curse, he was said to be the heir apparent to the Dark Lord, Voldemort. Now he has escaped, leaving only two clues as to where he might be headed: Harry Potter's defeat of You-Know-Who was Black's downfall as well. And the Azkaban guards heard Black muttering in his sleep, He's at Hogwarts. Harry Potter isn't safe, not even within the walls of his magical school, surrounded by his friends. Because on top of it all, there may well be a traitor in their midst."

            imageOne.setImageResource(R.drawable.hp3a)
            imageOne.setTag("hp3a")

            imageTwo.setImageResource(R.drawable.hp3b)
            imageTwo.setTag("hp3b")

            imageThree.setImageResource(R.drawable.hp3c)
            imageThree.setTag("hp3c")

            imageFour.setImageResource(R.drawable.hp3d)
            imageFour.setTag("hp3d")

            imageFive.setImageResource(R.drawable.hp3e)
            imageFive.setTag("hp3e")
        }

        else if (bookTag == "hp4") {
            storyTitle.text = "and the Goblet of Fire"
            synopsisText.text = "Harry Potter, a fourth-year student at Hogwarts School of Witchcraft and Wizardry, longs to escape his hateful relatives, the Dursleys, and live as a normal fourteen-year-old wizard, but what Harry does not yet realize is that he is not a normal wizard, and in his case, different can be deadly."

            imageOne.setImageResource(R.drawable.hp4a)
            imageOne.setTag("hp4a")

            imageTwo.setImageResource(R.drawable.hp4b)
            imageTwo.setTag("hp4b")

            imageThree.setImageResource(R.drawable.hp4c)
            imageThree.setTag("hp4c")

            imageFour.setImageResource(R.drawable.hp4d)
            imageFour.setTag("hp4d")

            imageFive.setImageResource(R.drawable.hp4e)
            imageFive.setTag("hp4e")
        }

        else if (bookTag == "hp5") {
            storyTitle.text = "and the Order of the Phoenix"
            synopsisText.text = "Harry Potter, now a fifth-year student at Hogwarts School of Witchcraft and Wizardry, struggles with a threatening teacher, a problematic house elf, the dread of upcoming final exams, and haunting dreams that hint toward his mysterious past."

            imageOne.setImageResource(R.drawable.hp5a)
            imageOne.setTag("hp5a")

            imageTwo.setImageResource(R.drawable.hp5b)
            imageTwo.setTag("hp5b")

            imageThree.setImageResource(R.drawable.hp5c)
            imageThree.setTag("hp5c")

            imageFour.setImageResource(R.drawable.hp5d)
            imageFour.setTag("hp5d")

            imageFive.setImageResource(R.drawable.hp5e)
            imageFive.setTag("hp5e")
        }

        else if (bookTag == "hp6") {
            storyTitle.text = "and the Half-Blood Prince"
            synopsisText.text = "Harry searches for the full and complex story of the boy who became Lord Voldemort, and thereby finds what may be his only vulnerability."

            imageOne.setImageResource(R.drawable.hp6a)
            imageOne.setTag("hp6a")

            imageTwo.setImageResource(R.drawable.hp6b)
            imageTwo.setTag("hp6b")

            imageThree.setImageResource(R.drawable.hp6c)
            imageThree.setTag("hp6c")

            imageFour.setImageResource(R.drawable.hp6d)
            imageFour.setTag("hp6d")

            imageFive.setImageResource(R.drawable.hp6e)
            imageFive.setTag("hp6e")
        }

        else if (bookTag == "hp7") {
            storyTitle.text = "and the Deathly Hallows"
            synopsisText.text = "Burdened with the dark, dangerous, and seemingly impossible task of locating and destroying Voldermort's remaining Horcruxes, Harry, feeling alone and uncertain about his future, struggles to find the inner strength he needs to follow the path set out before him."

            imageOne.setImageResource(R.drawable.hp7a)
            imageOne.setTag("hp7a")

            imageTwo.setImageResource(R.drawable.hp7b)
            imageTwo.setTag("hp7b")

            imageThree.setImageResource(R.drawable.hp7c)
            imageThree.setTag("hp7c")

            imageFour.setImageResource(R.drawable.hp7d)
            imageFour.setTag("hp7d")

            imageFive.setImageResource(R.drawable.hp7e)
            imageFive.setTag("hp7e")
        }

        else if (bookTag == "hp8") {
            storyTitle.text = "and the Cursed Child"
            synopsisText.text = "It was always difficult being Harry Potter and it isn’t much easier now that he is an overworked employee of the Ministry of Magic, a husband and father of three school-age children. While Harry grapples with a past that refuses to stay where it belongs, his youngest son Albus must struggle with the weight of a family legacy he never wanted. As past and present fuse ominously, both father and son learn the uncomfortable truth: sometimes, darkness comes from unexpected places."

            imageOne.setImageResource(R.drawable.hp8a)
            imageOne.setTag("hp8a")

            imageTwo.setImageResource(R.drawable.hp8b)
            imageTwo.setTag("hp8b")

            imageThree.setImageResource(R.drawable.hp8c)
            imageThree.setTag("hp8c")

            imageFour.setImageResource(R.drawable.hp8d)
            imageFour.setTag("hp8d")

            imageFive.setImageResource(R.drawable.hp8e)
            imageFive.setTag("hp8e")
        }

        else if (bookTag == "fb1") {
            hpfbText.text = "Fantastic Beasts"
            storyTitle.text = "and Where to Find Them"
            synopsisText.text = "While attending the Magical Congress of the United States of America in 1926, Newt Scamander is pursued by the wizarding authorities when dangerous beasts and their habitats escape from his magical briefcase."

            imageOne.setImageResource(R.drawable.fb1a)
            imageOne.setTag("fb1a")

            imageTwo.setImageResource(R.drawable.fb1b)
            imageTwo.setTag("fb1b")

            imageThree.setImageResource(R.drawable.fb1c)
            imageThree.setTag("fb1c")

            imageFour.setImageResource(R.drawable.fb1d)
            imageFour.setTag("fb1d")

            imageFive.setImageResource(R.drawable.fb1e)
            imageFive.setTag("fb1e")
        }

        else if (bookTag == "fb2") {
            hpfbText.text = "Fantastic Beasts"
            storyTitle.text = "and the Crimes of Grindelwald"
            synopsisText.text = "The powerful Dark wizard Gellert Grindelwald was captured in New York with the help of Newt Scamander. But, making good on his threat, Grindelwald escapes custody and sets about gathering followers, most of whom are unsuspecting of his true agenda: to raise pure-blood wizards up to rule over all non-magical beings."

            imageOne.setImageResource(R.drawable.fb2a)
            imageOne.setTag("fb2a")

            imageTwo.setImageResource(R.drawable.fb2b)
            imageTwo.setTag("fb2b")

            imageThree.setImageResource(R.drawable.fb2c)
            imageThree.setTag("fb2c")

            imageFour.setImageResource(R.drawable.fb2d)
            imageFour.setTag("fb2d")

            imageFive.setImageResource(R.drawable.fb2e)
            imageFive.setTag("fb2e")
        }

        else if (bookTag == "fb3") {
            hpfbText.text = "Fantastic Beasts"
            storyTitle.text = "and the Secrets of Dumbledore"
            synopsisText.text = "Professor Albus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts magizoologist Newt Scamander to lead an intrepid team of wizards and witches. They soon encounter an array of old and new beasts as they clash with Grindelwald's growing legion of followers."

            imageOne.setImageResource(R.drawable.fb3a)
            imageOne.setTag("fb3a")

            imageTwo.setImageResource(R.drawable.fb3b)
            imageTwo.setTag("fb3b")

            imageThree.setImageResource(R.drawable.fb3c)
            imageThree.setTag("fb3c")

            imageFour.setImageResource(R.drawable.fb3d)
            imageFour.setTag("fb3d")

            imageFive.setImageResource(R.drawable.fb3e)
            imageFive.setTag("fb3e")
        }
    }
}