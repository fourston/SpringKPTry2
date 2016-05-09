package com.cenyol.example.Services;

/**
 * Created by fours on 08.04.2016.
 */

import com.cenyol.example.model.ForumThreads;
import java.util.List;


public interface ForumThreadsService {
    List<ForumThreads> getAllThreads();
    ForumThreads addThread(ForumThreads thread);
    void deleteThread(long id);
    void closeThread(); //закрываем тред
}
