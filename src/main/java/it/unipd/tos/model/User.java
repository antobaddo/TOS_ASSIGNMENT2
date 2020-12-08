////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class User {
    private String id;
    private String firstName;
    private String surname;
    private int age;

    public User(String id, String firstName, String surname, int age) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }
    
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
