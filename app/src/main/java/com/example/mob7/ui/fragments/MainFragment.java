package com.example.mob7.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mob7.R;
import com.example.mob7.ui.vm.MainViewModel;

public class MainFragment extends Fragment {

    private MainViewModel viewModel;
    private Button buttonCheckStudents;
    private Button buttonCheckTeachers;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonCheckStudents = getActivity().findViewById(R.id.buttonStudents);
        buttonCheckTeachers = getActivity().findViewById(R.id.buttonTeachers);
        viewModel.getButtonNavigateToStudents().observe(getViewLifecycleOwner(), text ->
                buttonCheckStudents.setText(text));
        viewModel.getButtonNavigateToTeachers().observe(getViewLifecycleOwner(), text ->
                buttonCheckTeachers.setText(text));
        buttonCheckStudents.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", "students");
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_recyclerFragment, bundle);
        });
        buttonCheckTeachers.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", "teachers");
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_recyclerFragment, bundle);
        });
    }
}