package com.printifyproject.managers;
/*
example
    String sourceFilePath = "path/to/source/file.txt";
    String fileName = "copied_file.txt";
    copyFileToPackageDirectory(sourceFilePath, fileName);

 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ImageManager {


    public static void copyFileToImagesDirectory(String sourceFilePath, String fileName) {
        String destinationDirectoryPath = "src/main/resources/images/";
        String destinationFilePath = destinationDirectoryPath + fileName;

        File sourceFile = new File(sourceFilePath);

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            System.err.println("Source file does not exist or is not a valid file.");
            return;
        }

        try {
            Path source = sourceFile.toPath();
            Path destination = new File(destinationFilePath).toPath();
            Files.createDirectories(destination.getParent()); // Ensure the destination directory exists
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully to: " + destinationFilePath);
        } catch (IOException e) {
            System.err.println("Error copying the file: " + e.getMessage());
        }
    }
}
