package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreetimgImplTest {

    @Test
    public void greetShouldReturnValidOutput()
    {
      Greeting greet=new GreetimgImpl();  // creates a object of GreetImpl
        String result = greet.greet("JUnit");
        assertNotNull(greet); //checks the object is not null

        assertEquals("HelloJUnit",result);


    }


}