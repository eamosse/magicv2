package com.eamosse.users.user_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.eamosse.users.di.Injection.getRepository
import com.eamosse.users.model.User
import com.gmail.eamosse.users.R

class ListUserActivity : AppCompatActivity(), UserListAdapter.Listener {
    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    // TODO utiliser by lazy
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TODO("Utiliser le view binding")
        setContentView(R.layout.activity_list_user)
        configureFab()
        configureRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun configureRecyclerView() {
        recyclerView = findViewById(R.id.activity_list_user_rv)
        adapter = UserListAdapter(this)
        recyclerView.adapter = adapter
    }

    private fun configureFab() {
        fab = findViewById(R.id.activity_list_user_fab)
        fab.setOnClickListener { view: View? ->
            getRepository().addRandomUser()
            loadData()
        }
    }

    private fun loadData() {
        adapter.updateList(getRepository().getUsers())
    }

    override fun onClickDelete(user: User) {
        Log.d(ListUserActivity::class.java.name, "User tries to delete a item.")
        getRepository().deleteUser(user)
        loadData()
    }
}