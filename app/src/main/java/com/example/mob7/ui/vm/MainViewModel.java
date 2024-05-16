package com.example.mob7.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mob7.repository.AppRepository;

public class MainViewModel extends AndroidViewModel {
    private LiveData<String> buttonNavigateToStudents;
    private LiveData<String> buttonNavigateToTeachers;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppRepository appRepository = new AppRepository();
        buttonNavigateToStudents = appRepository.getNavigateButtonStudents();
        buttonNavigateToTeachers = appRepository.getNavigateButtonTeachers();

    }

    public LiveData<String> getButtonNavigateToStudents() {
        return buttonNavigateToStudents;
    }
    public LiveData<String> getButtonNavigateToTeachers() {
        return buttonNavigateToTeachers;
    }
}
