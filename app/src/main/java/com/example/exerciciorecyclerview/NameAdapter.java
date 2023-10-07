package com.example.exerciciorecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder>
{
    private List<NameItem> ListaDeNomes;

    public NameAdapter(List<NameItem> ListaDeNomes) {
        this.ListaDeNomes = ListaDeNomes;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position)
    {
        NameItem nameItem = ListaDeNomes.get(position);
        holder.textViewNome.setText(nameItem.getName());
    }

    @Override
    public int getItemCount() {
        return ListaDeNomes.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textViewNome;

        public NameViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
        }
    }
}
