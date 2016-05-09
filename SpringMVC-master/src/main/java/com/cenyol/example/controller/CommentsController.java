package com.cenyol.example.controller;

import com.cenyol.example.Services.CommentsService;
import com.cenyol.example.model.Comments2;
import com.cenyol.example.repository.CommentsRepository;
import com.cenyol.example.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by fours on 08.04.2016.
 */
@Controller
public class CommentsController {

    @Autowired
    private FilesRepository filesRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "commentsByFile/{fileId}", method = RequestMethod.GET)
    public String commentsByFile(@PathVariable("fileId") Long fileId, ModelMap modelMap) {
        List<Comments2> commentsByFile = commentsRepository.getCommentsByFile(fileId);
        modelMap.addAttribute("commentsByFile", commentsByFile);
        return "commentsByFile";
    }

    @RequestMapping(value = "/upRating/{id}", method = RequestMethod.GET)
    public String upRating(@PathVariable("id") Long id){
        commentsRepository.upRating(id);
        return "commentsByFile";
    }

    @RequestMapping(value = "/addCommentPost", method = RequestMethod.POST)
    public String addCommentPost(@ModelAttribute("comment") Comments2 comments){
        commentsService.addComment(comments);
        return "redirect:/fileDetails";
    }


}
