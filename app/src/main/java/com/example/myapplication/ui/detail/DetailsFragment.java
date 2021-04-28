package com.example.myapplication.ui.detail;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.data.model.Content;
import com.example.myapplication.databinding.DetailFragmentBinding;

public class DetailsFragment extends Fragment {

    private DetailFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DetailFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Content content = DetailsFragmentArgs.fromBundle(arguments).getItemContent();
            binding.tvTile.setText("Title : " + content.getMediaTitleCustom());
            binding.tvDate.setText("Date : " + content.getMediaDate().getDateString());
            binding.tvMedia.setText("Media URL : " + content.getMediaUrl());
        }
    }

}