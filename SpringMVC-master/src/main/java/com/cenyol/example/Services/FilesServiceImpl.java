package com.cenyol.example.Services;

/**
 * Created by fours on 07.04.2016.
 */

import com.cenyol.example.model.Files;
import com.cenyol.example.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configuration
public class FilesServiceImpl implements FilesService{

    @Autowired
    private FilesRepository filesRepository;


    public Files addFile(Files file){
        Files savedFile = filesRepository.saveAndFlush(file);
        return savedFile;
    }


    public void deleteFile(long id){
        filesRepository.deleteAllInBatch();
    }


    public List<Files> getAllFiles(){
        return filesRepository.findAll();

    }


    public List<Files> getAllRequests(){
        return filesRepository.getRequests();
    }


    public List<Files> getFilesById(long id){
        return filesRepository.getFilesById(id);
    }


    public List<Files> getRequestById(long id){
        return filesRepository.getRequestsById(id);
    }

}
