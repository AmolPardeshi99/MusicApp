package com.example.kotlin_scoping_functions

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(data: Data) {

        itemView.apply {
            data.run {
                tvId.text = id.toString()
                tvFirstName.text = firstName.toString()
                tvEmail.text = email.toString()
                Glide.with(ivAvatar).load(data.avatar).into(ivAvatar)
            }

            cardView.setOnClickListener {
                val alertDialog = AlertDialog.Builder(context)
                alertDialog.setTitle("Users Details")
                alertDialog.setMessage("First Name ${data.firstName}, Email:- ${data.email}")
                alertDialog.setPositiveButton("ok") { _, _ -> }
                alertDialog.show()
            }

        }
    }


}