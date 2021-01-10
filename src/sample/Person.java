package sample;

public class Person
{
    protected String firstname;
    protected String lastname;

    Person(){
        //constructor
        firstname = "";
        lastname = "";
    }

    Person(String name, String fam_name)
    {
        firstname = name;
        lastname = fam_name;
    }

    //settere si gettere
    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    String getterFirstname()
    {
        return firstname;
    }

    void setterFirstname(String newFirstName)
    {
        firstname = newFirstName;
    }

    String getterFamName()
    {
        return lastname;
    }

    void setterFamName(String newFamName)
    {
        lastname = newFamName;
    }
}
