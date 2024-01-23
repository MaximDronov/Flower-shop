package com.example.listsandadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<State> states;

    StateAdapter(Context context, List<State> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapter.ViewHolder holder, int position) {
        State state = states.get(position);
        holder.flowerView.setImageResource(state.getFlagResource());
        holder.nameView.setText(state.getName());
        holder.sortView.setText(state.getSort());
        holder.quantityView.setText(String.valueOf(state.getQuantity()));

        holder.checkBox.setChecked(state.isSelected());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            state.setSelected(isChecked);
        });

        // Обработчик нажатия на кнопку "Удалить"
        holder.buttonDelete.setOnClickListener(v -> {
            states.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, states.size());
        });

        holder.buttonPlus.setOnClickListener(v -> {
            int currentQuantity = state.getQuantity();
            state.setQuantity(currentQuantity + 1);
            holder.quantityView.setText(String.valueOf(state.getQuantity()));
        });

        holder.buttonMinus.setOnClickListener(v -> {
            int currentQuantity = state.getQuantity();
            if (currentQuantity > 0) {
                state.setQuantity(currentQuantity - 1);
                holder.quantityView.setText(String.valueOf(state.getQuantity()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView flowerView;
        final Button buttonPlus, buttonMinus;
        final TextView nameView, sortView, quantityView;
        final CheckBox checkBox;
        final Button buttonDelete;
        ViewHolder(View view) {
            super(view);
            flowerView = view.findViewById(R.id.flower);
            nameView = view.findViewById(R.id.name);
            sortView = view.findViewById(R.id.capital);
            quantityView = view.findViewById(R.id.quantity);
            buttonPlus = view.findViewById(R.id.buttonPlus);
            buttonMinus = view.findViewById(R.id.buttonMinus);
            checkBox = view.findViewById(R.id.checkBox);
            buttonDelete = view.findViewById(R.id.buttonDelete);
        }
    }
}
