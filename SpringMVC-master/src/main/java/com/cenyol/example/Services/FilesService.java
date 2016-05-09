package com.cenyol.example.Services;

/**
 * Created by fours on 07.04.2016.
 */

import com.cenyol.example.model.Files;

import java.util.List;

public interface FilesService {

    public Files addFile(Files file);
    void deleteFile(long id);
    public List<Files> getAllFiles(); //список всех файлов
    List<Files> getAllRequests(); //список файлов, которые находятся проверке
    List<Files> getFilesById(long id); //список файлов пользователя
    List<Files> getRequestById(long id); //список файлов, которые находятся на проверке, для определнного пользователя
    //void changeStatus(long id); - модератор потверждает, что файл проверен
}
