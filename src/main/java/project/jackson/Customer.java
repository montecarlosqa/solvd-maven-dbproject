package project.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Customer {
    @JsonProperty("id")
    private int id;
    @JsonProperty("first name")
    private String firstName;
    @JsonProperty("last name")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String lastName;
    @JsonProperty("birth date")
    private Date birthDate;
    @JsonProperty("driving license no.")
    private String drivingLicenseNumber;
    @JsonProperty("license issue date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date drivingLicenseIssueDate;

    public Customer(){}

    public Customer(int id, String firstName, String lastName, Date birthDate, String drivingLicenseNumber, Date drivingLicenseIssueDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.drivingLicenseIssueDate = drivingLicenseIssueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public Date getDrivingLicenseIssueDate() {
        return drivingLicenseIssueDate;
    }

    public void setDrivingLicenseIssueDate(Date drivingLicenseIssueDate) {
        this.drivingLicenseIssueDate = drivingLicenseIssueDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", drivingLicenseNumber='" + drivingLicenseNumber + '\'' +
                ", drivingLicenseIssueDate=" + drivingLicenseIssueDate +
                '}';
    }
}
