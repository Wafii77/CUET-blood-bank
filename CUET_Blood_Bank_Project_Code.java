
package com.example.cuetbloodbank;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up RecyclerView for Blood Availability
        RecyclerView bloodListRecyclerView = findViewById(R.id.bloodListRecyclerView);
        bloodListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data for blood availability
        ArrayList<BloodItem> bloodItems = new ArrayList<>();
        bloodItems.add(new BloodItem("A+", 10));
        bloodItems.add(new BloodItem("B+", 5));
        bloodItems.add(new BloodItem("O-", 3));
        bloodItems.add(new BloodItem("AB+", 7));

        // Adapter setup
        BloodAdapter adapter = new BloodAdapter(bloodItems);
        bloodListRecyclerView.setAdapter(adapter);
    }
}

class BloodItem {
    private String bloodType;
    private int quantity;

    public BloodItem(String bloodType, int quantity) {
        this.bloodType = bloodType;
        this.quantity = quantity;
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getQuantity() {
        return quantity;
    }
}

class BloodAdapter extends RecyclerView.Adapter<BloodAdapter.BloodViewHolder> {
    private ArrayList<BloodItem> bloodItems;

    public BloodAdapter(ArrayList<BloodItem> bloodItems) {
        this.bloodItems = bloodItems;
    }

    @Override
    public BloodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blood_item, parent, false);
        return new BloodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BloodViewHolder holder, int position) {
        BloodItem currentItem = bloodItems.get(position);
        holder.bloodTypeTextView.setText(currentItem.getBloodType());
        holder.quantityTextView.setText(String.valueOf(currentItem.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return bloodItems.size();
    }

    class BloodViewHolder extends RecyclerView.ViewHolder {
        TextView bloodTypeTextView;
        TextView quantityTextView;

        public BloodViewHolder(View itemView) {
            super(itemView);
            bloodTypeTextView = itemView.findViewById(R.id.bloodTypeTextView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
        }
    }
}
