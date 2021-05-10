package com.pocket.services;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    private static final String USER_FOLDER = System.getProperty("user.dir");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, "pocket-nutritionist-main","src","main","resources");

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }
}
