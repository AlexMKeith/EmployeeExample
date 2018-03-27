package com.elkcreek.rodneytressler.remediation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rodneytressler on 3/27/18.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private List<Employee> employeeList;

    public PersonAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(employeeList.get(position));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView employeeName;
        protected TextView employeeOccupation;

        public ViewHolder(View itemView) {
            super(itemView);
            employeeName = itemView.findViewById(R.id.text_employee_name);
            employeeOccupation = itemView.findViewById(R.id.text_employee_occupation);
        }

        public void bindView(Employee employee) {
            employeeName.setText(employee.getName());
            employeeOccupation.setText(employee.getOccupation());
        }
    }
}
