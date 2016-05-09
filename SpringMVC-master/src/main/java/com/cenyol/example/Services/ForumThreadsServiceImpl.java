package com.cenyol.example.Services;

/**
 * Created by fours on 08.04.2016.
 */
import com.cenyol.example.model.ForumThreads;
import com.cenyol.example.repository.ForumThreadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumThreadsServiceImpl implements ForumThreadsService {

    @Autowired
    public ForumThreadsRepository threadsRepository;

    @Override
    public List<ForumThreads> getAllThreads() {
        return threadsRepository.findAll();
    }

    @Override
    public ForumThreads addThread(ForumThreads thread) {
        ForumThreads savedThread = threadsRepository.saveAndFlush(thread);
        return savedThread;
    }

    @Override
    public void deleteThread(long id) {
        threadsRepository.deleteAllInBatch();
    }

    @Override
    public void closeThread() {

    }
}
