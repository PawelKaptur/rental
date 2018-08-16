package com.capgemini.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String occupation;

    //outpostentity czy dao, czy id, na razie id, relacje dodac
    private Long workplaceId;
    private Date dateOfBirth;
    private String city;
    private String street;
    private Integer postalCode;
    private Long phoneNumber;

    public static class WorkerTOBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String occupation;
        private Long workplaceId;
        private Date dateOfBirth;
        private String city;
        private String street;
        private Integer postalCode;
        private Long phoneNumber;

        public WorkerTOBuilder() {

        }

        public WorkerTOBuilder withId(Long id){
            this.id = id;
            return this;
        }

        public WorkerTOBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public WorkerTOBuilder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public WorkerTOBuilder withOccupation(String occupation){
            this.occupation = occupation;
            return this;
        }

        public WorkerTOBuilder withWorkplaceId(Long workplaceId){
            this.workplaceId = workplaceId;
            return this;
        }

        public WorkerTOBuilder withDateOfBirth(Date dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public WorkerTOBuilder withCity(String city){
            this.city = city;
            return this;
        }

        public WorkerTOBuilder withStreet(String street){
            this.street = street;
            return this;
        }

        public WorkerTOBuilder withPostalCode(Integer postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public WorkerTOBuilder withPhoneNumber(Long phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public WorkerTO build(){
            return new WorkerTO(id, firstName, lastName, occupation, workplaceId,dateOfBirth, city, street, postalCode, phoneNumber);
        }
    }
}
