package com.santisoft.tpmoviles3.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.santisoft.tpmoviles3.R;
import com.santisoft.tpmoviles3.ui.gallery.CargarViewModel;

public class CargarFragment extends Fragment {

    private CargarViewModel cargarViewModel;
    private EditText editTextNota;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cargar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextNota = view.findViewById(R.id.editTextText);
        Button buttonGuardar = view.findViewById(R.id.button);

        cargarViewModel = new ViewModelProvider(requireActivity()).get(CargarViewModel.class);

        buttonGuardar.setOnClickListener(v -> {
            String nota = editTextNota.getText().toString().trim();
            if (nota.isEmpty()) {
                Toast.makeText(getContext(), "La nota no puede estar vacía", Toast.LENGTH_SHORT).show();
            } else {
                cargarViewModel.crearNota(nota);
                editTextNota.setText("");
                NavHostFragment.findNavController(this).navigateUp();
            }
        });
    }
}
