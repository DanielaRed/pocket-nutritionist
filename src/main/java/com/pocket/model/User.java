package com.pocket.model;

import java.time.LocalDate;

public class User {

    private String username;
    private String password;
    private String role;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String phoneNumber;
    private String email;
    private Boolean verified;
    private int year;
    private int month;
    private int day;
    /*
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    */
    //private LocalDate dateofbirth;



    public User() {
    }

    public User(String username, String password, String role, LocalDate DateOfBirth, String PhoneNumber, String Email, Boolean verified) {
        this.username = username;
        this.password = password;
        this.role = role;
        //this.dateofbirth = DateOfBirth.toString();
        this.phoneNumber = PhoneNumber;
        this.email = Email;
        this.verified = verified;

        this.year = DateOfBirth.getYear();
        this.month = DateOfBirth.getMonthValue();
        this.day = DateOfBirth.getDayOfMonth();
        //System.out.println(this.username+ " " + this.password + " " + this.role + " " + day + " " + month + " " + year + " " + " " + phoneNumber + " " + email + " " + this.verified);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day=day;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month=month;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year=year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhone(String PhoneNumber) {
        this.phoneNumber = PhoneNumber;
    }

    public Boolean getVerifiedStatus() {
        return verified;
    }

    public void setVerifiedStatus(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        return role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", day='" + day +'\'' +
                ", month='" + month +'\'' +
                ", year='" + year +'\'' +
                ", phoneNumber='" + phoneNumber +'\'' +
                ", email='" + email + '\'' +
                ", verified='" + verified + '\'' +
                '}';
    }
}
