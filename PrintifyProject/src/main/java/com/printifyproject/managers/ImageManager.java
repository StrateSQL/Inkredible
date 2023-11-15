package com.printifyproject.managers;
/*
example
    String sourceFilePath = "path/to/source/file.txt";
    String fileName = "copied_file.txt";
    copyFileToPackageDirectory(sourceFilePath, fileName);

 */

import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ImageManager {

    public static void copyFileToPackageDirectory(String sourceFilePath, String fileName) {
        File sourceFile = new File(sourceFilePath);

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            System.err.println("Source file does not exist or is not a valid file.");
            return;
        }

        String destinationPackagePath = "com/printifyproject/images/";
        String destinationDirectoryPath = "src/main/java/" + destinationPackagePath;

        File destinationDirectory = new File(destinationDirectoryPath);
        if (!destinationDirectory.exists()) {
            if (!destinationDirectory.mkdirs()) {
                System.err.println("Failed to create the destination directory.");
                return;
            }
        }

        String destinationFilePath = destinationDirectoryPath + fileName;

        try {
            Path source = sourceFile.toPath();
            Path destination = new File(destinationFilePath).toPath();
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully to: " + destinationFilePath);
        } catch (IOException e) {
            System.err.println("Error copying the file: " + e.getMessage());
        }
    }

    public static Pair<String, String> splitFilePath(String fullPath) {
        Path path = FileSystems.getDefault().getPath(fullPath);

        String directory = path.getParent().toString();
        String filename = path.getFileName().toString();

        return new Pair<>(directory, filename);
    }

}
