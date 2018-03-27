package com.elkcreek.rodneytressler.remediation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainInterface {

    private List<Employee> employeeList;

    @BindView(R.id.input_name)
    protected EditText nameInput;

    @BindView(R.id.input_occupation)
    protected EditText occupationInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        employeeList = new ArrayList<>();
    }


    @OnClick(R.id.button_save_person)
    public void addPersonClicked() {
        String personName = nameInput.getText().toString();
        String personOccupation = occupationInput.getText().toString();

        Employee employee = new Employee(personName, personOccupation);
        employeeList.add(employee);

        nameInput.setText("");
        occupationInput.setText("");

        Toast.makeText(this, "Employee Added!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_view_list)
    public void viewListClicked() {
        EmployeeListFragment fragment = EmployeeListFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, fragment).commit();
        fragment.retrieveEmployeeList(employeeList);

    }
}
