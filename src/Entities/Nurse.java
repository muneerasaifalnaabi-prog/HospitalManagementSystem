package Entities;

import java.time.LocalDate;

public class Nurse extends Person{
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender ;
    private String phoneNumber ;
    private String email ;
    private String address ;

    public Nurse(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String id1, String firstName1, LocalDate dateOfBirth1, String lastName1, String gender1, String phoneNumber1, String email1, String address1) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.id = id1;
        this.firstName = firstName1;
        this.dateOfBirth = dateOfBirth1;
        this.lastName = lastName1;
        this.gender = gender1;
        this.phoneNumber = phoneNumber1;
        this.email = email1;
        this.address = address1;
    }
}
