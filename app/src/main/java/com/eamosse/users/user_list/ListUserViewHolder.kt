package com.eamosse.users.user_list

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eamosse.users.model.User
import com.gmail.eamosse.users.R

class ListUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // TODO Utiliser le view binding
    private var avatar: ImageView = itemView.findViewById(R.id.item_list_user_avatar)
    private val username: TextView = itemView.findViewById(R.id.item_list_user_username)
    private val deleteButton: ImageButton = itemView.findViewById(R.id.item_list_user_delete_button)

    fun bind(user: User, callback: UserListAdapter.Listener) {
        // TODO afficher l'image de l'utilisateur en utilisant Glide ou Coil
        // TODO afficher le nom de l'utilisateur
        // TODO gérer le clic sur le bouton de suppression
    }

}