package com.cenyol.example.Services;

/**
 * Created by fours on 20.05.2016.
 */
import com.cenyol.example.model.ThreadComments;

import java.util.List;

public interface ThreadCommentsService {
    ThreadComments addThreadComment(ThreadComments threadComment);
    void deleteThreadComment(long id);
    List<ThreadComments> getThreadComments(int threadId);
}
