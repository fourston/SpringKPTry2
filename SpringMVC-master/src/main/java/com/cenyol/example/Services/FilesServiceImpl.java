package com.cenyol.example.Services;

/**
 * Created by fours on 20.05.2016.
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


    public Files addFile(String path, String name, String size, String ext){
        Files file = new Files();
        file.setName(name);
        file.setExt(ext);
        file.setPathToFile(path);
        file.setSizeOfFile(size);
        file.setStatus("check");
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


    public List<Files> getFilesById(String name){
        return filesRepository.getFilesById(name);
    }


    public List<Files> getRequestById(String name){
        return filesRepository.getRequestsById(name);
    }

}
