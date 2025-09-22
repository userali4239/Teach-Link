package com.example.crudapp;

public class model
{

    // Declaring instance variables for the model class (representing a teacher)
    String name,course,email,surl,number;

    // Default constructor
    model()
    {
        // This constructor is required by Firebase for mapping data from the database to this object.
    }


    // Parameterized constructor to initialize the object with data
    public model(String name, String course, String surl, String email, String number) {
        this.name = name;       // Initialize the teacher's name
        this.course = course;   // Initialize the course the teacher is teaching
        this.surl = surl;       // Initialize the teacher's image URL (for profile picture)
        this.email = email;     // Initialize the teacher's email address
        this.number = number;   // Initialize the teacher's phone number
    }


    // Getter method for the 'course' property
    public String getCourse()
    {
        return course;  // Returns the course value
    }


    // Setter method for the 'course' property
    public void setCourse(String course)
    {
        this.course = course;  // Sets a new value for the course
    }

    // Getter method for the 'name' property
    public String getName()
    {
        return name;  // Returns the teacher's name
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSurl()
    {
        return surl;
    }

    public void setSurl(String surl)
    {
        this.surl = surl;
    }
    public String getNumber()
    {
        return number;
    }

    public void  setNumber()
    {
        this.number = number;
    }
}

