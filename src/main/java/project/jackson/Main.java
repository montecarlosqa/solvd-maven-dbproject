package project.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class Main {
    public static void getIndentLine(){
        System.out.println("----------------------");
    }
    public static void main(String[] args){
        Location location = new Location(1,"54456 Heil", "Anaheim", "California"," United states", "77410");
        CarCategory carCategory = new CarCategory(1,"Compact", 36.60);
        Insurance insurance = new Insurance(1,"AAA", "AAA is the best auto insurance company in California because of its affordable rates, dependable coverage and great support.");
        Customer customer = new Customer(1,"Blaze", "Hobbs", new Date(),"A0002144",new Date());
        Car car = new Car(1, carCategory, "Toyota", "Tacoma", 2002, 17600, "Black", location);

        try {
            ObjectMapper locationObjectMapper = new ObjectMapper();
            String locationJson = locationObjectMapper.writeValueAsString(location);
            System.out.println(locationJson);

            Location deseralizedLocation = locationObjectMapper.readValue(locationJson, Location.class);
            System.out.println("Deserialized location: " + deseralizedLocation);
            getIndentLine();

            ObjectMapper carCategoryObjectMapper = new ObjectMapper();
            String carCategoryJson = carCategoryObjectMapper.writeValueAsString(carCategory);
            System.out.println(carCategoryJson);

            CarCategory deserializedCarCategory = carCategoryObjectMapper.readValue(carCategoryJson, CarCategory.class);
            System.out.println("Deserialized car category: " + deserializedCarCategory);
            getIndentLine();

            ObjectMapper insuranceObjectMapper = new ObjectMapper();
            String insuranceJson = insuranceObjectMapper.writeValueAsString(insurance);
            System.out.println(insuranceJson);

            Insurance deserializedInsurance = insuranceObjectMapper.readValue(insuranceJson, Insurance.class);
            System.out.println("Deserialized insurance: " + deserializedInsurance);
            getIndentLine();

            ObjectMapper customerObjectMapper = new ObjectMapper();
            String customerJson = customerObjectMapper.writeValueAsString(customer);
            System.out.println(customerJson);

            Customer deserializedCustomer = customerObjectMapper.readValue(customerJson, Customer.class);
            System.out.println("Deserialized customer: " + deserializedCustomer);
            getIndentLine();

            ObjectMapper carObjectMapper = new ObjectMapper();
            String carJson = carObjectMapper.writeValueAsString(car);
            System.out.println(carJson);

            Car deserializedCar = carObjectMapper.readValue(carJson, Car.class);
            System.out.println("Deserialized car: " + deserializedCar);
            getIndentLine();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
