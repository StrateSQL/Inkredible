package com.printifyproject.orm.examples;

import com.printifyproject.orm.model.ColorEntity;
import com.printifyproject.orm.service.ColorService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ColorExample {

    public static void colorExample() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ColorService colorService = ctx.getBean(ColorService.class);

        List<ColorEntity> colors = new ArrayList<>();

        colors.add(new ColorEntity ("Red", "EEEEEE"));

        //colorService.createAll(colors);

        ctx.close();
    }
}
