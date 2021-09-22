package ua.com.alevel.controller;

import ua.com.alevel.model.ExtensionType;
import ua.com.alevel.model.FileModel;
import ua.com.alevel.service.FileService;
import ua.com.alevel.service.FileServiceImpl;

public class FileController {

    public void run() {
        FileService service = new FileServiceImpl();
        String input = service.read("input.txt");
        FileModel file = new FileModel();
        file.setName("output");
        file.setExtensionType(ExtensionType.TXT);
        file.setContent(service.getOutput(input));
        service.create(file);
    }
}
