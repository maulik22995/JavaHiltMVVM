package com.example.myapplication.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.common.helper.SwipeToDeleteCallback;
import com.example.myapplication.data.model.Content;
import com.example.myapplication.data.model.PressReleaseModel;
import com.example.myapplication.databinding.ListFragmentBinding;
import com.example.myapplication.ui.list.adapter.PressReleaseAdapter;

import dagger.hilt.android.AndroidEntryPoint;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

@AndroidEntryPoint
public class ListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, PressReleaseAdapter.OnItemClickListener {

    ListViewModel mViewModel;
    private ListFragmentBinding binding;
    private PressReleaseAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.recyclerVwMain.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        binding.recyclerVwMain.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerVwMain.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mAdapter = new PressReleaseAdapter(this);
        binding.recyclerVwMain.setAdapter(mAdapter);

        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this.getContext()) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                mAdapter.removeItem(viewHolder.getAdapterPosition());
            }
        };
        new ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(binding.recyclerVwMain);

        binding.swipeRefresh.setOnRefreshListener(this);

        mViewModel = new ViewModelProvider(this).get(ListViewModel.class);
        mViewModel.liveDataPressRelease.observe(getViewLifecycleOwner(), new Observer<PressReleaseModel>() {
            @Override
            public void onChanged(PressReleaseModel pressReleaseModel) {
                if (pressReleaseModel != null) {
                    binding.swipeRefresh.setRefreshing(false);
                    mAdapter.addAllItem(pressReleaseModel.getContent());
                }
            }
        });

        onRefresh();


    }

    @Override
    public void onRefresh() {
        mViewModel.fetchData();
    }

    @Override
    public void onItemClicked(Content contents) {
        ListFragmentDirections.ActionListFragmentToDetailsFragment directions = ListFragmentDirections.actionListFragmentToDetailsFragment(contents);
        findNavController(this).navigate(directions);
    }
}