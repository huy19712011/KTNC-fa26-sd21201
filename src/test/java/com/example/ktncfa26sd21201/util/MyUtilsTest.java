package com.example.ktncfa26sd21201.util;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilsTest {

    static MyUtils myUtils;

    @BeforeAll
    static void setUpBeforeAll() {

        System.out.println("Set up before all");
        myUtils = new MyUtils();
    }

    @AfterAll
    static void tearDownAfterAll() {

        System.out.println("Clear after all");
    }

    @Test
    @DisplayName("Cong 2 so nguyen")
    void add() {

        Assertions.assertEquals(5, myUtils.add(2, 3));
        System.out.println("Done...");
    }

    @Test
    @DisplayName("Dao nguoc chuoi")
    void reverse() {

        // abc => cba
        assertEquals("cba", myUtils.reverse("abc"));
    }
}