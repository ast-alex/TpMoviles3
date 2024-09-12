package com.santisoft.tpmoviles3.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.santisoft.tpmoviles3.MainActivity;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mError;

    public CargarViewModel(@NonNull Application application) {
        super(application);
        mError = new MutableLiveData<>();
    }

    public LiveData<String> getMError() {
        return mError;
    }

    public void crearNota(String notaNueva) {
        if (notaNueva.isEmpty()) {
            mError.setValue("La tarea no puede estar vacía");
            return;
        }

        if (MainActivity.notas.contains(notaNueva)) {
            mError.setValue("La tarea ya existe");
            return;
        }

        // Si la tarea no existe, la agregamos
        MainActivity.notas.add(notaNueva);
        mError.setValue(null);  // No hay error
    }
}
