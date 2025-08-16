package com.namansharma.ex_06_TestAssetions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting026_TestNG_Assertions {

//    @Test
//    public void test_hardAssert(){
//        System.out.println("Start of Program");
//        Assert.assertEquals("naman","NAMAN");
//        System.out.println("End of Program");
//    }


    @Test
    public void test_softAssert(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Naman","NAMAN");
        softAssert.assertEquals("Sharma","Sharma");
        System.out.println("End of Program");
        softAssert.assertAll();
    }


}
