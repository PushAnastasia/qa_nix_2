package ua.com.alevel.service;

import ua.com.alevel.model.FileModel;

public interface FileService {

    void create(FileModel fileModel);

    String read(String fileName);

    String getOutput(String input);
}
