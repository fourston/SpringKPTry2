package com.cenyol.example.Services;

/**
 * Created by fours on 20.05.2016.
 */
import com.cenyol.example.model.ForumThreads;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface ForumThreadsService {
    List<ForumThreads> getAllThreads();
    ForumThreads addThread(ForumThreads thread);
    void deleteThread(long id);
    void closeThread(); //закрываем тред
}
