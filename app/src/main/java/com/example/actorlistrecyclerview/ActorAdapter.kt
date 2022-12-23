package com.example.actorlistrecyclerview


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



class ActorAdapter(val context: Context,
                   val actorList: ArrayList<Actor>,
                   val userClickListener: (Actor, Int) -> Unit
): RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {


    class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var txtName: TextView? = null
        var txtFilm: TextView? = null
        var imgActor: ImageView? = null
        var btnDelete: Button? = null


        init {
            txtName = itemView.findViewById(R.id.txtName)
            txtFilm = itemView.findViewById(R.id.txtFilm)
            imgActor = itemView.findViewById(R.id.imgActor)
            btnDelete = itemView.findViewById(R.id.rvDelete)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_actor_item, parent, false)
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val currentActor: Actor = actorList[position]
        holder.txtName?.text = currentActor.Name
        holder.txtFilm?.text = currentActor.Film
        holder.imgActor?.let { Glide.with(context).load(currentActor.Image).centerCrop().into(it) }
        holder.itemView.setOnClickListener {
            userClickListener(currentActor, position)
            Toast.makeText(context,"Age: ${currentActor.Age}", Toast.LENGTH_LONG).show()

        }
        holder.btnDelete?.setOnClickListener {
            deleteActor(currentActor)
        }


    }

    override fun getItemCount(): Int = actorList.size

    fun addActor(actor: Actor) {
        actorList.add(actor)
        notifyItemInserted(actorList.size)
    }

    fun deleteActor(actor: Actor) {
        val position = actorList.indexOf(actor)
        actorList.removeAt(position)
        notifyItemRemoved(position)
    }


}
