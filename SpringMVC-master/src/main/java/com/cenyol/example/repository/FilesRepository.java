package com.cenyol.example.repository;

/**
 * Created by fours on 07.04.2016.
 */

import com.cenyol.example.model.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FilesRepository extends JpaRepository<Files, Long>{
    @Modifying
    @Transactional
    @Query("select f from Files f where f.status = 'check'")
    List<Files> getFiles();

    @Query("select f from Files f where f.status = 'uncheck'")
    List<Files> getRequests();

    @Query("select f from Files f where f.status = 'check' and f.userId = ?1")
    List<Files> getFilesById(long userId);

    @Query("select f from Files f where f.status = 'uncheck' and f.userId = ?1")
    List<Files> getRequestsById(long userId);



}

