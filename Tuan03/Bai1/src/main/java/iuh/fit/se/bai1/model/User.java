package iuh.fit.se.bai1.model;

import java.time.LocalDate;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private LocalDate DateOfBirth;
    private String email;
    private String mobileNumber;
    private boolean gender;
    private String address;
    private String city;
    private int pinCode;
    private String state;
    private String country;
    private List<String> hobbies;
    private String[] qualification;
    private String courseAppliesFor;

    public User() {
    }

    public User(String firstName, String lastName, LocalDate dateOfBirth, String email, String mobileNumber, boolean gender, String address, String city, int pinCode, String state, String country, List<String> hobbies, String[] qualification, String courseAppliesFor) {
        this.firstName = firstName;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.hobbies = hobbies;
        this.qualification = qualification;
        this.courseAppliesFor = courseAppliesFor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String[] getQualification() {
        return qualification;
    }

    public void setQualification(String[] qualification) {
        this.qualification = qualification;
    }

    public String getCourseAppliesFor() {
        return courseAppliesFor;
    }

    public void setCourseAppliesFor(String courseAppliesFor) {
        this.courseAppliesFor = courseAppliesFor;
    }
}
