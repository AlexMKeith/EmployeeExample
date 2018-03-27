package com.elkcreek.rodneytressler.remediation;

/**
 * Created by rodneytressler on 3/27/18.
 */

public class Employee {

    private String name;
    private String occupation;

    public Employee(String name, String occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }
}
