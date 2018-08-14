package com.capgemini.service;

import com.capgemini.types.OutpostTO;
import com.capgemini.types.OutpostTO.OutpostTOBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutpostTest {

    @Autowired
    private OutpostService outpostService;

    @Test
    public void shouldAddOutpost(){

        //given
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO addedOutpost = outpostService.addOutpost(outpostTO);

        //when
        OutpostTO selectedOutpost = outpostService.findOutpostById(addedOutpost.getId());

        //then
        assertThat(selectedOutpost.getId()).isEqualTo(addedOutpost.getId());
    }
}
