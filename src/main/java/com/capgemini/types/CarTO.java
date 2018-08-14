package com.capgemini.types;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarTO {

    private Long id;

    private String type;
    private String brand;
    private String model;
    private Integer productionYear;
    private String color;
    private Double engineCapacity;
    private Integer power;
    private Integer course;

    private Date dateOfCreating;
    private Date dateOfEditing;

    public static CarTOBuilder builder() {
        return new CarTOBuilder();
    }

    public static class CarTOBuilder {
        private Long id;
        private String type;
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

        }

        public CarTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CarTOBuilder withType(String carType) {
            this.type = carType;
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

        public CarTOBuilder withDateOfCreating(Date dateOfCreating){
            this.dateOfCreating = dateOfCreating;
            return this;
        }

        public CarTOBuilder withDateOfEditing(Date dateOfEditing){
            this.dateOfEditing = dateOfEditing;
            return this;
        }

        //daty tutaj?

        public CarTO build(){
            //check
            return new CarTO(id, type, brand, model, productionYear, color, engineCapacity, power, course, dateOfCreating, dateOfEditing);
        }
    }
}
