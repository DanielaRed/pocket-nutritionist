package com.pocket.model;

import java.time.LocalDate;
import java.time.Year;

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
    private int calories;
    private String gender;
    private String full_name;
    private String height;
    private String weight;
    private String allergies;
    private String diet_type;
    /*
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    */
    //private LocalDate dateofbirth;



    public User() {
    }

    public User(String username, String password, String role, LocalDate DateOfBirth, String PhoneNumber, String Email,
                 String FullName, String Gender, String Allergies, String Height, String Weight,  String DietType, Boolean verified) {

        this.username = username;
        this.password = password;
        this.role = role;

        this.phoneNumber = PhoneNumber;
        this.email = Email;
        this.verified = verified;

        this.gender = Gender;
        this.full_name = FullName;
        this.height = Height;
        this.weight = Weight;
        this.allergies = Allergies;
        this.diet_type = DietType;

        this.year = DateOfBirth.getYear();
        this.month = DateOfBirth.getMonthValue();
        this.day = DateOfBirth.getDayOfMonth();
        //System.out.println(this.username+ " " + this.password + " " + this.role + " " + day + " " + month + " " + year + " " + " " + phoneNumber + " " + email + " " + this.verified);

        if(this.gender.compareTo("Female")==0)
        {
            this.calories = (int)((447.6 + 9.25 * Integer.parseInt(this.weight)) + (3.1 * Integer.parseInt(this.height)) - (4.33d * (Year.now().getValue() - this.year)));
        }

        if(this.gender.compareTo("Male")==0)
        {
            this.calories = (int)((88.4 + 13.4 * Integer.parseInt(this.weight)) + (4.8 * Integer.parseInt(this.height)) - (5.68 * (Year.now().getValue() - this.year)));
        }

        if(this.diet_type.compareTo("Muscle-Gain")==0)
        {
            this.calories = (int)(this.calories * 1.55);
        }



    }

    public User(String username, String password, String role, LocalDate DateOfBirth, String PhoneNumber, String Email, String FullName, Boolean verified) {
        this.username = username;
        this.password = password;
        this.role = role;

        this.phoneNumber = PhoneNumber;
        this.email = Email;
        this.verified = verified;
        this.full_name = FullName;

        this.year = DateOfBirth.getYear();
        this.month = DateOfBirth.getMonthValue();
        this.day = DateOfBirth.getDayOfMonth();
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

    public int getCalories()
    {
        return calories;
    }

    public void setCalories(int calories)
    {
        this.calories=calories;
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

    public String getGender(){
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullName(){
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public String getHeight(){
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight(){
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAllergies(){
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getDietType(){
        return diet_type;
    }

    public void setDietType(String diet_type) {
        this.diet_type = diet_type;
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
                ", gender='" + gender +'\''+
                ", full_name='" + full_name +'\''+
                ", height='" + height +'\''+
                ", weight='" + weight +'\''+
                ", allergies='" + allergies +'\''+
                ", diet_type='" + diet_type +'\''+
                ", verified='" + verified + '\'' +
                '}';
    }
}

