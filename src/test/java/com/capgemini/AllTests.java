package com.capgemini;

import com.capgemini.service.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CarTest.class, OutpostTest.class, RentalTest.class, ClientTest.class, WorkerTest.class})
public class AllTests {

}
