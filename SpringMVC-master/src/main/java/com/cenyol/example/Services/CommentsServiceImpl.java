package com.cenyol.example.Services;

/**
 * Created by fours on 08.04.2016.
 */

import com.cenyol.example.model.Comments2;
import com.cenyol.example.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Configuration
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    public CommentsRepository commentsRepository;


    public Comments2 addComment(Comments2 comment){
        Comments2 savedComment = commentsRepository.saveAndFlush(comment);
        return savedComment;
    }


    public void deleteComment(Long id){
        commentsRepository.deleteAllInBatch();
    }


    public List<Comments2> getAllCommentsByFile(Long fileId){
        return commentsRepository.getCommentsByFile(fileId);
    }


    public void upRating(Long id){
        commentsRepository.upRating(id);
    }


    public void downRating(Long id){
        Comments2 comment = commentsRepository.findOne(id);
        comment.setRating(comment.getRating()-1);
    }

}
