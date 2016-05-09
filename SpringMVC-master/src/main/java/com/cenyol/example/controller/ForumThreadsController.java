package com.cenyol.example.controller;

/**
 * Created by fours on 20.05.2016.
 */
import com.cenyol.example.model.ForumThreads;
import com.cenyol.example.repositoryUser.ForumThreadsRepository;
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
public class ForumThreadsController {

    @Autowired
    ForumThreadsRepository threadsRepository;

    @RequestMapping(value = "/forum", method = RequestMethod.GET)
    public String threads(ModelMap modelMap){
        List<ForumThreads> threadsList = threadsRepository.findAll();
        modelMap.addAttribute("threadsList", threadsList);
        return "forum";
    }

    @RequestMapping(value = "/showThread/{threadId}", method = RequestMethod.GET)
    public String showThread(@PathVariable("threadId") Integer threadId, ModelMap modelMap ){
        ForumThreads forumThreads = threadsRepository.findOne(threadId);
        modelMap.addAttribute("thread", forumThreads);
        return "forumDetail";
    }

    @RequestMapping(value = "/addThread", method = RequestMethod.GET)
    public String addThread(){
        return "addThread";
    }


    @RequestMapping(value = "/addThreadPost", method = RequestMethod.POST)
    public String addThreadPost(@ModelAttribute("threads") ForumThreads threads){

        threadsRepository.saveAndFlush(threads);


        return "redirect:/forum";
    }

}