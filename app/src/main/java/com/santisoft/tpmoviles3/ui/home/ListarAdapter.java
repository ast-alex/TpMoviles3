package com.santisoft.tpmoviles3.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.santisoft.tpmoviles3.R;

import java.util.ArrayList;
import java.util.List;

public class ListarAdapter extends RecyclerView.Adapter<ListarAdapter.NotaViewHolder> {

    private List<String> notas;

    // Constructor
    public ListarAdapter(List<String> notas) {
        this.notas = notas;
    }

    // Método para actualizar la lista de notas
    public void updateNotas(List<String> nuevasNotas) {
        this.notas = nuevasNotas;
        notifyDataSetChanged(); // Refresca la lista de notas cuando cambien los datos
    }

    @NonNull
    @Override
    public NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout para cada elemento de la lista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota, parent, false);
        return new NotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaViewHolder holder, int position) {
        // Asignar el valor de la nota al TextView correspondiente
        String nota = notas.get(position);
        holder.textViewNota.setText(nota);
    }

    @Override
    public int getItemCount() {
        // Devolver el tamaño de la lista de notas
        return notas.size();
    }

    // ViewHolder interno para representar cada ítem de la lista
    public class NotaViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNota;

        public NotaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNota = itemView.findViewById(R.id.textViewNota);
        }

        public void bind(String nota) {
            textViewNota.setText(nota);
        }
    }

}
