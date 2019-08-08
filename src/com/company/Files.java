package com.company;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public interface Files {
    String readFromFile(@NotNull String path);
    void appendToFile(@NotNull File file, String content);
}
