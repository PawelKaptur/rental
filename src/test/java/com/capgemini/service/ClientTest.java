package com.capgemini.service;


import com.capgemini.types.ClientTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
public class ClientTest {

    @Autowired
    private ClientService clientService;

    @Test
    @Transactional
    public void shouldAddRental() {
        //given
        ClientTO clientTO = new ClientTO().builder().dateOfBirth(new Date()).street("asd").postalCode(12345)
                .phoneNumber(987654321L).firstName("Seba").lastName("Kox").city("qwe")
                .creditCardNumber("1234567890123456").email("seba.kox@gmailcom")
                .build();

        ClientTO addedClient = clientService.addClient(clientTO);

        //when
        ClientTO selectedClient = clientService.findClientById(addedClient.getId());

        //then
        assertThat(selectedClient.getId()).isEqualTo(addedClient.getId());
    }
}
