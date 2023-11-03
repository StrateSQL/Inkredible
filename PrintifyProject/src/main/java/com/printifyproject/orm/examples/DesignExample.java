package com.printifyproject.orm.examples;

import com.printifyproject.orm.model.DesignEntity;
import com.printifyproject.orm.service.DesignService;
import com.printifyproject.orm.service.ServiceHelper;
import javafx.util.Pair;

import static com.printifyproject.images.ManageImages.copyFileToPackageDirectory;
import static com.printifyproject.images.ManageImages.splitFilePath;

public class DesignExample {

    public static void createDesign () {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        DesignService designService = serviceHelper.getDesignService();

        designService.findAll().forEach(design -> designService.deleteById(design.getDesignId()));

        DesignEntity design = new DesignEntity();

        design.setTitle("Ah! The Element Of Surprise");
        design.setDescription("<p>Get ready to add a dash of humor to your wardrobe with our witty t-shirt that proudly " +
                "displays \"The Element Of Surprise\" under the chemical symbol \"Ah.\" This clever design is perfect for " +
                "those who love a good play on words and enjoy keeping others on their toes. Whether you're a science " +
                "enthusiast or simply appreciate a good joke, this shirt will surely spark conversations and laughter " +
                "wherever you go. Embrace the unexpected and let the element of surprise be your signature style!</p>\n");

        design.setImage("D:\\Dropbox\\T-Shirts\\04-Produced\\Funny\\Ah The Element Of Surprise\\The Element Of Surprise.png");
        design = designService.add(design);

        String image = design.getImage();
        Pair<String, String> file = splitFilePath(image);
        copyFileToPackageDirectory(file.getKey(), file.getValue());

        System.out.println(design.toString());
    }
}
