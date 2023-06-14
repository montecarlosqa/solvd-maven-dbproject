package project.jaxb;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Equipment {
    @XmlAttribute
    private int id;
    @XmlElement
    private String equipment;

    public Equipment(){}
    public Equipment(int id, String equipment) {
        this.id = id;
        this.equipment = equipment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", equipment='" + equipment + '\'' +
                '}';
    }
}
