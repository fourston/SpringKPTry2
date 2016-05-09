package com.cenyol.example.repository;

/**
 * Created by fours on 08.04.2016.
 */
import com.cenyol.example.model.Comments2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments2, Long>{
    @Modifying
    @Transactional

    @Query("select c from Comments2 c where c.fileId = ?1")
    List<Comments2> getCommentsByFile(long fileId);

    @Query("update Comments2 c set c.Rating=c.Rating+1 where c.id = ?1")
    void upRating(Long id);

}
