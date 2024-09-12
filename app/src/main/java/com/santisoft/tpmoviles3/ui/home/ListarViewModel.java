package com.santisoft.tpmoviles3.ui.home;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.santisoft.tpmoviles3.MainActivity;

import java.util.ArrayList;

public class ListarViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<String>> notasLiveData;

    public ListarViewModel(@NonNull Application application) {
        super(application);
        notasLiveData = new MutableLiveData<>(new ArrayList<>(MainActivity.notas));
        refreshNotas();
    }

    public LiveData<ArrayList<String>> getNotasLiveData() {
        return notasLiveData;
    }
    public void refreshNotas(){
        //ordenar sin importar el ingreso de Mayuscula o minuscula.
        ArrayList<String> sortedNotas = new ArrayList<>(MainActivity.notas);
        sortedNotas.sort(String.CASE_INSENSITIVE_ORDER);
        notasLiveData.setValue(sortedNotas);
    }
}
