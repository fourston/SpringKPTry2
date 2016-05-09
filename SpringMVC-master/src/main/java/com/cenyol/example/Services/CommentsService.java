package com.cenyol.example.Services;

/**
 * Created by fours on 20.05.2016.
 */

import com.cenyol.example.model.Comments2;
import com.cenyol.example.model.Files;

import java.util.List;

public interface CommentsService {


    Comments2 addComment(Comments2 comment, Files files);
    void deleteComment(Long id);
    List<Comments2> getAllCommentsByFile(Long id);
    void upRating(Long id);
    void downRating(Long id);
}
