package com.cenyol.example.Services;

/**
 * Created by fours on 08.04.2016.
 */
import com.cenyol.example.model.ThreadComments;
import com.cenyol.example.repository.ThreadCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadCommentsServiceImpl implements ThreadCommentsService{

    @Autowired
    public ThreadCommentsRepository threadCommentsRepository;

    @Override
    public ThreadComments addThreadComment(ThreadComments threadComment) {
        ThreadComments savedThreadComment = threadCommentsRepository.saveAndFlush(threadComment);
        return savedThreadComment;
    }

    @Override
    public void deleteThreadComment(long id) {
        threadCommentsRepository.deleteAllInBatch();
    }

    @Override
    public List<ThreadComments> getThreadComments(int threadId) {
        return threadCommentsRepository.getThreadCommentsByThread(threadId);
    }




}
