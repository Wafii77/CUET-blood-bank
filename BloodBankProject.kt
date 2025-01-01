
// MainActivity.kt
package com.example.cuetbloodbank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up RecyclerView for Blood Availability
        val bloodListRecyclerView: RecyclerView = findViewById(R.id.bloodListRecyclerView)
        bloodListRecyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data for blood availability
        val bloodItems = arrayListOf(
            BloodItem("A+", 10),
            BloodItem("B+", 5),
            BloodItem("O-", 3),
            BloodItem("AB+", 7)
        )

        // Adapter setup
        val adapter = BloodAdapter(bloodItems)
        bloodListRecyclerView.adapter = adapter
    }
}

// BloodItem.kt
package com.example.cuetbloodbank

data class BloodItem(
    val bloodType: String,
    val quantity: Int
)

// BloodAdapter.kt
package com.example.cuetbloodbank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BloodAdapter(private val bloodItems: ArrayList<BloodItem>) :
    RecyclerView.Adapter<BloodAdapter.BloodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BloodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.blood_item, parent, false)
        return BloodViewHolder(view)
    }

    override fun onBindViewHolder(holder: BloodViewHolder, position: Int) {
        val currentItem = bloodItems[position]
        holder.bloodTypeTextView.text = currentItem.bloodType
        holder.quantityTextView.text = currentItem.quantity.toString()
    }

    override fun getItemCount(): Int = bloodItems.size

    class BloodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bloodTypeTextView: TextView = itemView.findViewById(R.id.bloodTypeTextView)
        val quantityTextView: TextView = itemView.findViewById(R.id.quantityTextView)
    }
}
