package com.orinil.Gakkou.test02;

public class Course {
    //Fields to initialize the properties we work with in the project.
    private String id;
    private String name;
    private String description;

    public Course() {

    }
    //A constructor for the three properties
    public Course(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    //Getters and setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
