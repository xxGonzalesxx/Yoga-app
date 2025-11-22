package com.example.yogga1
import android.content.Intent
import com.example.yogga1.ui.PoseDetailActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yogga1.adapter.PoseAdapter
import com.example.yogga1.util.DataProvider

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var poseAdapter: PoseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        poseAdapter = PoseAdapter(DataProvider.yogaPoses) { pose ->
            val intent = Intent(this, PoseDetailActivity::class.java)
            intent.putExtra("pose", pose)
            startActivity(intent)
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = poseAdapter
        }
    }
}
