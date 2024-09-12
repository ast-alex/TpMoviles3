package com.santisoft.tpmoviles3.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.santisoft.tpmoviles3.databinding.FragmentListarBinding;
import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private ListarViewModel listarViewModel;
    private FragmentListarBinding binding;
    private ListarAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Utilizamos View Binding para inflar el layout
        binding = FragmentListarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializar el ViewModel
        listarViewModel = new ViewModelProvider(this).get(ListarViewModel.class);

        // Configurar el RecyclerView
        adapter = new ListarAdapter(new ArrayList<>());
        binding.lista.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.lista.setAdapter(adapter);

        // Observar cambios en las notas y actualizar el adaptador
        listarViewModel.getNotasLiveData().observe(getViewLifecycleOwner(), notas -> {
            // Actualizamos la lista de notas en el adaptador cuando cambia la lista observada
            adapter.updateNotas(notas);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        listarViewModel.refreshNotas();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Liberar el binding cuando se destruye la vista
        binding = null;
    }
}
