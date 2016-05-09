package com.cenyol.example.Services;

/**
 * Created by fours on 20.05.2016.
 */
import com.cenyol.example.model.Files;

import java.util.List;

public interface FilesService {

    public Files addFile(String path, String name, String size, String ext);
    void deleteFile(long id);
    public List<Files> getAllFiles(); //список всех файлов
    List<Files> getAllRequests(); //список файлов, которые находятся проверке
    List<Files> getFilesById(String name); //список файлов пользователя
    List<Files> getRequestById(String name); //список файлов, которые находятся на проверке, для определнного пользователя
    //void changeStatus(long id); - модератор потверждает, что файл проверен
}
