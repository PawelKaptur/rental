package com.capgemini.types;

import lombok.*;

import java.util.Date;
import java.util.List;

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
    
    private List<Long> wardensId;
    private List<Long> rentals;

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

        private List<Long> wardens;
        private List<Long> rentals;

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

        public CarTOBuilder withWardens(List<Long> wardens){
            this.wardens = wardens;
            return this;
        }

        public CarTOBuilder withRentals(List<Long> rentals){
            this.rentals = rentals;
            return this;
        }

        public CarTO build(){
            return new CarTO(id, type, brand, model, productionYear, color, engineCapacity, power, course, wardens, rentals, dateOfCreating, dateOfEditing);
        }
    }
}
