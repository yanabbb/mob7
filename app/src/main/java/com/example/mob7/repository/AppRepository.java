package com.example.mob7.repository;

import androidx.lifecycle.LiveData;

import com.example.mob7.data_source.AppData;
import com.example.mob7.model.ItemModel;

import java.util.List;

public class AppRepository {

    public LiveData<List<ItemModel>> getStudentsData() { return AppData.buildStudentsData(); }
    public LiveData<List<ItemModel>> getTeachersData() { return AppData.buildTeachersData(); }
    public LiveData<String> getNavigateButtonStudents() { return AppData.getNavigateToStudents(); }
    public LiveData<String> getNavigateButtonTeachers() { return AppData.getNavigateToTeachers(); }
    public LiveData<String> getStudentsTitle() { return AppData.getStudentsTitle(); }
    public LiveData<String> getTeachersTitle() { return AppData.getTeachersTitle(); }
}
