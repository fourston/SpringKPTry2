package com.cenyol.example.Services;

/**
 * Created by fours on 20.05.2016.
 */
import com.cenyol.example.model.ThreadComments;
import com.cenyol.example.repositoryUser.ThreadCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadCommentsServiceImpl implements ThreadCommentsService{


    @Autowired
    public ThreadCommentsRepository threadCommentsRepository;


    public ThreadComments addThreadComment(ThreadComments threadComment) {
        ThreadComments savedThreadComment = threadCommentsRepository.saveAndFlush(threadComment);
        return savedThreadComment;
    }


    public void deleteThreadComment(long id) {
        threadCommentsRepository.deleteAllInBatch();
    }


    public List<ThreadComments> getThreadComments(int threadId) {
        return threadCommentsRepository.getThreadCommentsByThread(threadId);
    }




}
