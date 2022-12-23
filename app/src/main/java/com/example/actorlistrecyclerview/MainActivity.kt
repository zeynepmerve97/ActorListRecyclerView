package com.example.actorlistrecyclerview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAdd : Button = findViewById(R.id.btnAdd)
        val arrayList = ArrayList<Actor>()
        val arrayListAdd = ArrayList<Actor>()
        val rv: RecyclerView = findViewById(R.id.rvActor)



        //list image url
        val imgHL = "https://st.depositphotos.com/1814084/1733/i/950/depositphotos_17332327-stock-photo-heath-ledger.jpg"
        val imgJM = "https://st2.depositphotos.com/1814084/5204/i/950/depositphotos_52045189-stock-photo-jason-momoa.jpg"
        val imgJR = "https://st2.depositphotos.com/3429495/11747/i/950/depositphotos_117478100-stock-photo-julia-roberts-actress.jpg"
        val imgBC = "https://st2.depositphotos.com/1814084/5224/i/950/depositphotos_52241763-stock-photo-benedict-cumberbatch.jpg"
        val imgAJ = "https://st.depositphotos.com/3429495/5053/i/600/depositphotos_50532925-stock-photo-angelina-jolie.jpg"
        val imgAH = "https://st.depositphotos.com/1814084/1517/i/450/depositphotos_15176551-stock-photo-anne-hathaway.jpg"
        val imgJA = "https://st4.depositphotos.com/1729220/26794/i/450/depositphotos_267945242-stock-photo-jennifer-aniston-new-york-premiere.jpg"
        val imgJL = "https://st4.depositphotos.com/5326338/27350/i/450/depositphotos_273506992-stock-photo-actress-jennifer-lawrence-los-angeles.jpg"
        val imgRG = "https://st2.depositphotos.com/4504115/11006/i/450/depositphotos_110069082-stock-photo-ryan-gosling-attends-the-nice.jpg"
        // create actors and add arrayList
        val actor2 = Actor("Heath Ledger","10 THINGS I HATE ABOUT YOU",28,imgHL)
        val actor3 = Actor("Jason Momoa","GOT",33,imgJM)
        val actor4 = Actor("Julia Roberts","Nothing Hill",53,imgJR)
        val actor5 = Actor("Benedict Cumberbatch","Sherlock",46,imgBC)
        val actor6 = Actor("Angelina Jolie","Lara Croft",45,imgAJ)
        val actor7 = Actor("Anne Hathaway","One Day",40,imgAH)
        val actor8 = Actor("Jennifer Aniston","Friends",51,imgJA)
        val actor9 = Actor("Jennifer Lawrence","Red Sparrow",29,imgJL)
        val actor10 = Actor("Ryan Gosling","The NoteBook",33,imgRG)


        arrayList.add(actor2)
        arrayList.add(actor3)
        arrayList.add(actor4)
        arrayList.add(actor5)

        arrayListAdd.add(actor6)
        arrayListAdd.add(actor7)
        arrayListAdd.add(actor8)
        arrayListAdd.add(actor9)
        arrayListAdd.add(actor10)



        val actorAdapter: ActorAdapter =  ActorAdapter(this,arrayList){
                currentActor: Actor,position: Int ->

        }




        // add new actor
        btnAdd.setOnClickListener {
            if (arrayListAdd.isNotEmpty()){
                actorAdapter.addActor(arrayListAdd.last())
                arrayListAdd.removeAt(arrayListAdd.size - 1)
            }

        }



        rv.adapter = actorAdapter

        rv.layoutManager = LinearLayoutManager(this)



    }




}


