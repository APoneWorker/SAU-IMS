package com.fekpal.dao;

import com.fekpal.domain.Message;
import com.fekpal.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by APone on 2017/8/23.
 * messageDao接口
 */
@Repository
public interface MessageDao {

    Message getMessageByMessageId(int messageId);

    List<Message> getMessageByUser(User user);
}
