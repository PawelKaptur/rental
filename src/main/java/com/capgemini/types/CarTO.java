package com.capgemini.types;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class CarTO {

    private Long id;

    private String carType;
    private String brand;
    private String model;
    private Long productionYear;
    private String color;
    private Double engineCapacity;
    private Integer power;
    private Integer course;


/*    @ManyToOne
    private OutpostEntity currentLocationId;*/

    private Date dateOfCreating;
    private Date dateOfEditing;

    public static CarTOBuilder builder() {
        return new CarTOBuilder();
    }

    public static class CarTOBuilder {
        private Long id;
        private String carType;
        private String brand;
        private String model;
        private Integer productionYear;
        private String color;
        private Double engineCapacity;
        private Integer power;
        private Integer course;
        private Date dateOfCreating;
        private Date dateOfEditing;

        public CarTOBuilder(){
            super();
        }

        public CarTOBuilder withId(Long id){
            this.id = id;
            return this;
        }

        public CarTOBuilder withCarType(String carType){
            this.carType = carType;
            return this;
        }

        public CarTOBuilder withBrand(String brand){
            this.brand = brand;
            return this;
        }

        public CarTOBuilder withModel(String model){
            this.model = model;
            return this;
        }

        public CarTOBuilder withProductionYear(Integer productionYear){
            this.productionYear = productionYear;
            return this;
        }
    }
}
