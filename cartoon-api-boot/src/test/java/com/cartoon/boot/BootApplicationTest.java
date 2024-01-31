package com.cartoon.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BootApplicationTest {

    @Test
    public void BootTest()  {
        Assertions.assertDoesNotThrow(() -> BootApplication.main(new String[] { }));
    }
}
