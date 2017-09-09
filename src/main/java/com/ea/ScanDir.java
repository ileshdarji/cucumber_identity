package com.ea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScanDir {

    public static void main(String[] args) {
        try {
            Files.walk(Paths.get("path/to/local/dir")) //please set the path to your local directory
                    .distinct()
                    .forEach((Path p) -> {
                        try {
                            System.out.println(String.format("File: %s is %s bytes", p.toFile().getAbsolutePath(), Files.size(p)));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
