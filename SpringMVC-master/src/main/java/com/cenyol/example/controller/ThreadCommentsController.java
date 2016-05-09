package com.cenyol.example.controller;

/**
 * Created by fours on 20.05.2016.
 */
import com.cenyol.example.model.ThreadComments;
import com.cenyol.example.repositoryUser.ThreadCommentsRepository;
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
public class ThreadCommentsController {

    @Autowired
    ThreadCommentsRepository threadCommentsRepository;

    @RequestMapping(value = "commentsByThread/{idThread}", method = RequestMethod.GET)
    public String commentsByThread(@PathVariable("idThread") Integer idThread, ModelMap modelMap) {
        List<ThreadComments> commentsByThread = threadCommentsRepository.getThreadCommentsByThread(idThread);
        modelMap.addAttribute("commentsByThread", commentsByThread);
        return "commentsByThread";
    }

    @RequestMapping(value = "/addThreadCommentPost", method = RequestMethod.POST)
    public String addThreadPost(@ModelAttribute("threadComment") ThreadComments threadComments) {
        threadCommentsRepository.saveAndFlush(threadComments);
        return "redirect:/showThread";
    }
}
