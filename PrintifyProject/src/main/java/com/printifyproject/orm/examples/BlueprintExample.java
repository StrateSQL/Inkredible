package com.printifyproject.orm.examples;

import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.service.BlueprintService;
import com.printifyproject.orm.service.ServiceHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BlueprintExample {
    public static void getBlueprintDataViaCtx() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        BlueprintService blueprintService = ctx.getBean(BlueprintService.class);
        var prints = blueprintService.findAll();
        ctx.close();
    }

    public static void getBlueprintDataViaHelper() {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        BlueprintService blueprintService = serviceHelper.getBlueprintService();
        var prints = blueprintService.findAll();
    }

    public static void createComboBoxDataSet() {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        BlueprintService blueprintService = serviceHelper.getBlueprintService();
        List<BlueprintEntity> blueprints = blueprintService.findAll();

        ObservableList<BlueprintEntity> blueprintList = FXCollections.observableArrayList(blueprints);
        ComboBox<BlueprintEntity> comboBox = new ComboBox<>(blueprintList);
    }
}
