package com.cenyol.example.repository;

/**
 * Created by fours on 08.04.2016.
 */
import com.cenyol.example.model.ThreadComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ThreadCommentsRepository extends JpaRepository<ThreadComments, Integer>{
    @Query("select t from ThreadComments t where idThread = ?1")
    List<ThreadComments> getThreadCommentsByThread(int threadId);
}
