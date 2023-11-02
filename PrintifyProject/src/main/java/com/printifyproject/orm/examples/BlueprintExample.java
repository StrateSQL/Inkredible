package com.printifyproject.orm.examples;

import com.printifyproject.orm.service.BlueprintService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BlueprintExample {
    public static void getBlueprintData() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        BlueprintService blueprintService = ctx.getBean(BlueprintService.class);
        var prints = blueprintService.findAll();
        ctx.close();
    }
}
