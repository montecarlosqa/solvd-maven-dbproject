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
    public static void main(String[] args) throws SQLException {

//        try{
//            Car car = new Car();
//            car.setBrand("Toyota");
//            car.setModel("Tacoma");
//            car.setProductionDate(new Date());
//            car.setMileage(17600);
//            car.setColor("Black");
//            car.setCurrentLocation(new Location("32040 Lyons circle","Huntington Beach", "California", "United States", "92801"));
//            List<Equipment> equipmentList = new ArrayList<>();
//            equipmentList.add(new Equipment(1,"Booster seat"));
//            equipmentList.add(new Equipment(2,"GPS"));
//            equipmentList.add(new Equipment(3,"Toddler seat"));
//            car.setEquipments(equipmentList);
//
//            File file = new File("src/main/resources/car.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.marshal(car, file);
//            jaxbMarshaller.marshal(car, System.out);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

        try{
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

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
