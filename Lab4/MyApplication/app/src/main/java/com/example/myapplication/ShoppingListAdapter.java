package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    private List<String> items;
    private boolean[] checkedState;

    public ShoppingListAdapter(List<String> items) {
        this.items = items;
        this.checkedState = new boolean[items.size()];
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shopping_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewItemName.setText(items.get(position));
        holder.checkBoxItem.setChecked(checkedState[position]);
        holder.checkBoxItem.setOnCheckedChangeListener((buttonView, isChecked) -> {
            checkedState[position] = isChecked;
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewItemName;
        public CheckBox checkBoxItem;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewItemName = itemView.findViewById(R.id.textViewItemName);
            checkBoxItem = itemView.findViewById(R.id.checkboxItem);
        }
    }
}
