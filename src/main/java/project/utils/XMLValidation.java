package project.utils;

import org.w3c.dom.Document;
import project.dao.CarCategoryDAO;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class XMLValidation {
    public static void getIndentLine(){
        System.out.println("----------------------");
    }

    private static boolean validateXMLSchema(String xmlFilePath){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setFeature("http://apache.org/xml/features/validation/schema", true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(null);
            builder.parse(xmlFilePath);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private static void parseLocationXMLWithDOM(String xmlFilePath){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);

            String streetAddress = document.getElementsByTagName("streetAddress").item(0).getTextContent();
            String city = document.getElementsByTagName("city").item(0).getTextContent();
            String state = document.getElementsByTagName("state").item(0).getTextContent();
            String country = document.getElementsByTagName("country").item(0).getTextContent();
            String zip = document.getElementsByTagName("zip").item(0).getTextContent();
            System.out.printf(
                    "Street address: %s \n" +
                    "City: %s\n" +
                    "State: %s\n" +
                    "Country: %s\n" +
                    "Zip: %s", streetAddress, city, state, country, zip);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parseCarCategoryXMLWithDOM(String xmlFilePath){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);

            String categoryName = document.getElementsByTagName("categoryName").item(0).getTextContent();
            String rentalValue = document.getElementsByTagName("rentalValue").item(0).getTextContent();
            System.out.printf(
                    "Category name: %s \n" +
                    "Rental value: %s" , categoryName, rentalValue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parseCustomerXMLWithDOM(String xmlFilePath){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);

            String firstName = document.getElementsByTagName("firstname").item(0).getTextContent();
            String lastName = document.getElementsByTagName("lastname").item(0).getTextContent();
            String birthDate = document.getElementsByTagName("birthdate").item(0).getTextContent();
            String drivingLicenseNumber = document.getElementsByTagName("drivingLicenseNumber").item(0).getTextContent();
            String drivingLicenseIssueDate = document.getElementsByTagName("drivingLicenseIssueDate").item(0).getTextContent();
            System.out.printf(
                    "First name: %s \n" +
                            "Last name: %s\n" +
                            "Birth date: %s\n" +
                            "Driving license no: %s\n" +
                            "Driving license issue date: %s", firstName, lastName, birthDate, drivingLicenseNumber, drivingLicenseIssueDate);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parseCarXMLWithDOM(String xmlFilePath){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);

            String carCategory = document.getElementsByTagName("carcategory").item(0).getTextContent();
            String brand = document.getElementsByTagName("brand").item(0).getTextContent();
            String model = document.getElementsByTagName("model").item(0).getTextContent();
            String productionYear = document.getElementsByTagName("productionYear").item(0).getTextContent();
            String mileage = document.getElementsByTagName("mileage").item(0).getTextContent();
            String color = document.getElementsByTagName("color").item(0).getTextContent();
            String currentLocation = document.getElementsByTagName("currentlocation").item(0).getTextContent();
            System.out.printf(
                    "Car Category: %s \n" +
                            "Brand: %s\n" +
                            "Model: %s\n" +
                            "Production year: %s\n" +
                            "Mileage : %s\n" +
                            "Color: %s\n" +
                            "Current location: %s", carCategory, brand, model, productionYear, mileage, color, currentLocation);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parseInsuranceXMLWithDOM(String xmlFilePath){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);

            String insuranceName = document.getElementsByTagName("insuranceName").item(0).getTextContent();
            String description = document.getElementsByTagName("description").item(0).getTextContent();
            String cost = document.getElementsByTagName("cost").item(0).getTextContent();
            System.out.printf(
                    "Insurance name: %s \n" +
                    "Description: %s\n" +
                     "Cost %s" , insuranceName, description, cost);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {

//        String xmlLocationFilePath = "src/test/location.xml";
//
//        boolean isLocationValid = validateXMLSchema(xmlLocationFilePath);
//        System.out.println("XML validation result: " + isLocationValid);
//
//        if(isLocationValid){
//            parseLocationXMLWithDOM(xmlLocationFilePath);
//        }
//        getIndentLine();
//
//        String xmlCarCategoryFilePath = "src/test/carcategory.xml";
//
//        boolean isCarCategoryValid = validateXMLSchema(xmlCarCategoryFilePath);
//        System.out.println("XML validation result: " + isCarCategoryValid);
//
//        if(isCarCategoryValid){
//            parseCarCategoryXMLWithDOM(xmlCarCategoryFilePath);
//        }
//        getIndentLine();
//
//        String xmlCustomerFilePath = "src/test/customer.xml";
//
//        boolean isCustomerValid = validateXMLSchema(xmlCustomerFilePath);
//        System.out.println("XML validation result: " + isCustomerValid);
//
//        if(isCustomerValid){
//            parseCustomerXMLWithDOM(xmlCustomerFilePath);
//        }
//        getIndentLine();
//
//        String xmlInsuranceFilePath = "src/test/insurance.xml";
//
//        boolean isInsuranceValid = validateXMLSchema(xmlInsuranceFilePath);
//        System.out.println("XML validation result: " + isInsuranceValid);
//
//        if(isInsuranceValid){
//            parseInsuranceXMLWithDOM(xmlInsuranceFilePath);
//        }
//        getIndentLine();
//
//        String xmlCarFilePath = "src/test/car.xml";
//
//        boolean isCarValid = validateXMLSchema(xmlCarFilePath);
//        System.out.println("XML validation result: " + isCarValid);
//
//        if(isCarValid){
//            parseCarXMLWithDOM(xmlCarFilePath);
//        }
    }
}
