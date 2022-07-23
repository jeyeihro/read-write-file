package com.github.jeyeihro.readwritefile.example;

import org.junit.jupiter.api.Test;

class ReadMeTest {
    @Test
    void mainTest_1(){
        //noinspection InstantiationOfUtilityClass
        new ReadMe();
    }

    @Test
    void mainTest_2(){
        ReadMe.main(new String[0]);
    }
}