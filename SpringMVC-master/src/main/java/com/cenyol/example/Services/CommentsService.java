package com.cenyol.example.Services;

/**
 * Created by fours on 08.04.2016.
 */

import com.cenyol.example.model.Comments2;
import java.util.List;

public interface CommentsService {


    Comments2 addComment(Comments2 comment);
    void deleteComment(Long id);
    List<Comments2> getAllCommentsByFile(Long fileId);
    void upRating(Long id);
    void downRating(Long id);
}
