package project.jaxb;
import project.model.CarCategory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {
    public static void getIndentLine(){
        System.out.println("----------------------");
    }
    public static void main(String[] args) throws SQLException {

        try{
            //Creation of car object
            Car car = new Car();
            car.setBrand("Toyota");
            car.setModel("Tacoma");
            car.setProductionDate(new Date());
            car.setMileage(17600);
            car.setColor("Black");
            car.setCurrentLocation(new Location("32040 Lyons circle","Huntington Beach", "California", "United States", "92801"));
            List<Equipment> equipmentList = new ArrayList<>();
            equipmentList.add(new Equipment(1,"Booster seat"));
            equipmentList.add(new Equipment(2,"GPS"));
            equipmentList.add(new Equipment(3,"Toddler seat"));
            car.setEquipments(equipmentList);
            //Marshalling of the car object
            File file = new File("src/main/resources/car.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(car, file);
            jaxbMarshaller.marshal(car, System.out);
            getIndentLine();
            //Creation of location object
            Location location = new Location();
            location.setStreetAddress("19752 lyons circle");
            location.setCity("Anaheim");
            location.setState("California");
            location.setCountry("United States");
            location.setZip("92564");
            //Marshalling of the location object
            File file2 = new File("src/main/resources/location.xml");
            JAXBContext jaxbContext2 = JAXBContext.newInstance(Location.class);
            Marshaller jaxbMarshaller2 = jaxbContext2.createMarshaller();
            jaxbMarshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller2.marshal(location, file2);
            jaxbMarshaller2.marshal(location, System.out);
            getIndentLine();
            //Creation of equipment object
            Equipment equipment = new Equipment();
            equipment.setId(1);
            equipment.setEquipment("Booster seat");
            //Marshalling of the equipment object
            File file3 = new File("src/main/resources/equipment.xml");
            JAXBContext jaxbContext3 = JAXBContext.newInstance(Equipment.class);
            Marshaller jaxbMarshaller3 = jaxbContext3.createMarshaller();
            jaxbMarshaller3.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller3.marshal(equipment, file3);
            jaxbMarshaller3.marshal(equipment, System.out);


        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try{
            //Getting the car xml file for unmarshalling and assigning it to car object for us to print.
            File file = new File("src/main/resources/car.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Car car = (Car) jaxbUnmarshaller.unmarshal(file);

            System.out.println("Brand: " + car.getBrand());
            System.out.println("Model: " + car.getModel());
            System.out.println("Production date: " + car.getProductionDate());
            System.out.println("Mileage: " + car.getMileage());
            System.out.println("Color: " + car.getColor());
            System.out.println("Current location: " + car.getCurrentLocation());
            System.out.println("Equipments: " + car.getEquipments());
            getIndentLine();
            //Getting the location xml file for unmarshalling and assigning it to location object for us to print.
            File file2 = new File("src/main/resources/location.xml");
            JAXBContext jaxbContext2 = JAXBContext.newInstance(Location.class);
            Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
            Location location = (Location) jaxbUnmarshaller2.unmarshal(file2);

            System.out.println("Street Address: " + location.getStreetAddress());
            System.out.println("City: " + location.getCity());
            System.out.println("State: " + location.getState());
            System.out.println("Country: " + location.getCountry());
            System.out.println("Zip: " + location.getZip());
            getIndentLine();
            //Getting the equipment xml file for unmarshalling and assigning it to equipment object for us to print.
            File file3 = new File("src/main/resources/equipment.xml");
            JAXBContext jaxbContext3 = JAXBContext.newInstance(Equipment.class);
            Unmarshaller jaxbUnmarshaller3 = jaxbContext3.createUnmarshaller();
            Equipment equipment = (Equipment) jaxbUnmarshaller3.unmarshal(file3);

            System.out.println("Equipment id: " + equipment.getId());
            System.out.println("Equipment: " + equipment.getEquipment());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
