package com.capgemini.service;

import com.capgemini.types.OutpostTO;
import com.capgemini.types.OutpostTO.OutpostTOBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutpostTest {

    @Autowired
    private OutpostService outpostService;

    @Before
    public void setUp(){
        outpostService.deleteAll();
    }

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

    @Test
    public void shouldDeleteAllOutpostFromRepository(){
        //given
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        outpostService.addOutpost(outpostTO);

        //when
        outpostService.deleteAll();
        List<OutpostTO> outposts = outpostService.findAll();

        //then
        assertThat(outposts).isEmpty();
    }

    @Test
    public void shouldFindThreeCarsInRepository(){
        //given
        OutpostTO outpostTO = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO outpostTO2 = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        OutpostTO outpostTO3 = new OutpostTOBuilder().withPhoneNumber(123456789L)
                .withEmail("out1@gmail.com").withStreet("Mokebe")
                .withPostalCode(21345).withCity("New York").build();
        outpostService.addOutpost(outpostTO);
        outpostService.addOutpost(outpostTO2);
        outpostService.addOutpost(outpostTO3);

        //when
        List<OutpostTO> outposts = outpostService.findAll();

        //then
        assertThat(outposts.size()).isEqualTo(3);
    }
}
