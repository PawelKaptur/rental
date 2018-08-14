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

    private Date dateOfCreating;
    private Date dateOfEditing;

    public static CarTOBuilder builder() {
        return new CarTOBuilder();
    }

    public CarTO(String brand, Long id) {
        super();
        this.brand = brand;
        this.id = id;
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

        public CarTOBuilder() {
            super();
        }

        public CarTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CarTOBuilder withCarType(String carType) {
            this.carType = carType;
            return this;
        }

        public CarTOBuilder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarTOBuilder withModel(String model) {
            this.model = model;
            return this;
        }

        public CarTOBuilder withProductionYear(Integer productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public CarTOBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public CarTOBuilder withEngineCapacity(Double engineCapacity) {
            this.engineCapacity = engineCapacity;
            return this;
        }

        public CarTOBuilder withPower(Integer power) {
            this.power = power;
            return this;
        }

        public CarTOBuilder withCourse(Integer course) {
            this.course = course;
            return this;
        }

        //daty tutaj?

        public CarTO build(){
            //check
            return new CarTO(brand, id);
        }
    }
}
