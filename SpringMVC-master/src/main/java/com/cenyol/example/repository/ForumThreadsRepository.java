package com.cenyol.example.repository;

/**
 * Created by fours on 08.04.2016.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import com.cenyol.example.model.ForumThreads;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumThreadsRepository extends JpaRepository<ForumThreads, Integer>{

}