package com.example.mytablayout_pager;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentShopping extends Fragment {

    private ArrayList<ShoppingItem> shoppingItems = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shopping, container, false);

        shoppingItems = ShoppingItem.getData();

        recyclerView = view.findViewById(R.id.itemRecyclerView);
        recyclerView.setAdapter(new ShoppingItemAdapter(shoppingItems, getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }
}