package com.capgemini;

import com.capgemini.service.CarTest;
import com.capgemini.service.OutpostTest;
import com.capgemini.service.RentalTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CarTest.class, OutpostTest.class, RentalTest.class})
public class AllTests {

}
