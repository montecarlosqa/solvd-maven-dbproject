package project.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Insurance {
    @JsonProperty("id")
    private int id;
    @JsonProperty("insurance name")
    private String insuranceName;
    @JsonProperty("insurance description")
    private String insuranceDesc;

    private Insurance(){}

    public Insurance(int id, String insuranceName, String insuranceDesc) {
        this.id = id;
        this.insuranceName = insuranceName;
        this.insuranceDesc = insuranceDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuranceDesc() {
        return insuranceDesc;
    }

    public void setInsuranceDesc(String insuranceDesc) {
        this.insuranceDesc = insuranceDesc;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", insuranceName='" + insuranceName + '\'' +
                ", insuranceDesc='" + insuranceDesc + '\'' +
                '}';
    }
}
