package com.capgemini.types;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutpostTO {

    private Long id;
    private String city;
    private String street;
    private Integer postalCode;
    private Long phoneNumber;
    private String email;

    public static class OutpostTOBuilder{
        private Long id;
        private String city;
        private String street;
        private Integer postalCode;
        private Long phoneNumber;
        private String email;

        public OutpostTOBuilder(){

        }

        public OutpostTOBuilder withId(Long id){
            this.id = id;
            return this;
        }

        public OutpostTOBuilder withCity(String city){
            this.city = city;
            return this;
        }

        public OutpostTOBuilder withStreet(String street){
            this.street = street;
            return this;
        }

        public OutpostTOBuilder withPostalCode(Integer postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public OutpostTOBuilder withPhoneNumber(Long phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public OutpostTOBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public OutpostTO build(){
            return new OutpostTO(id, city, street, postalCode, phoneNumber, email);
        }
    }
}
