package com.cenyol.example.Services;

/**
 * Created by fours on 20.05.2016.
 */
import com.cenyol.example.model.ForumThreads;
import com.cenyol.example.repositoryUser.ForumThreadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ForumThreadsServiceImpl implements ForumThreadsService {


    @Autowired
    public ForumThreadsRepository threadsRepository;


    public List<ForumThreads> getAllThreads() {
        return threadsRepository.findAll();
    }

    @Transactional(value = "tx2")
    public ForumThreads addThread(ForumThreads thread) {
        ForumThreads savedThread = threadsRepository.saveAndFlush(thread);
        return savedThread;
    }


    public void deleteThread(long id) {
        threadsRepository.deleteAllInBatch();
    }


    public void closeThread() {

    }
}
