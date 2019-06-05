package com.example.demo.service;

import com.example.demo.DemoController;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class DigitServiceTest {


    private DemoController controller = new DemoController();

    @Test
    public void Test() {
        controller.printAllStr(new int[]{2, 9});
    }

    @Test
    public void Test1() {
        String convert = controller.convert(99);
        System.out.print(convert);
    }

}
