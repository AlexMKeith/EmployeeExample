package com.elkcreek.rodneytressler.remediation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rodneytressler on 3/27/18.
 */

public class EmployeeListFragment extends Fragment {

    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private PersonAdapter adapter;
    private List<Employee> employeeList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static EmployeeListFragment newInstance() {

        Bundle args = new Bundle();

        EmployeeListFragment fragment = new EmployeeListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void retrieveEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PersonAdapter(employeeList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
