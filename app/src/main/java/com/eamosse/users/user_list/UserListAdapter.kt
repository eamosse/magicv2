package com.eamosse.users.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.eamosse.users.model.User
import com.gmail.eamosse.users.R

class UserListAdapter(
    private val callback: Listener
) : RecyclerView.Adapter<ListUserViewHolder>() {

    private val mDiffer: AsyncListDiffer<User> =
        AsyncListDiffer(this, DIFF_CALLBACK)

    interface Listener {
        fun onClickDelete(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_list_user, parent, false)
        return ListUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        holder.bind(mDiffer.currentList[position], callback)
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    // PUBLIC API ---
    fun updateList(newList: List<User>) {
        mDiffer.submitList(newList)
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<User> =
            object : DiffUtil.ItemCallback<User>() {
                override fun areItemsTheSame(
                    oldItem: User,
                    newItem: User
                ): Boolean {
                    // TODO : Fix me : The comparison is not correct
                    return false
                }

                override fun areContentsTheSame(
                    oldItem: User,
                    newItem: User
                ): Boolean {
                    //TODO : Fix me : The comparison is not correct
                    return false
                }
            }
    }
}