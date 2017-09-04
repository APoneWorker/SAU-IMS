package test.dao;

import com.fekpal.dao.MessageDao;
import com.fekpal.dao.MessageReleaseDao;
import com.fekpal.dao.UserDao;
import com.fekpal.domain.MessageRelease;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static test.dao.Domain.*;

/**
 * Created by APone on 2017/9/4.
 */
public class MessageReleaseDaoTest extends BaseDaoTest {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private MessageReleaseDao messageReleaseDao;

    @Autowired
    private UserDao userDao;

    @Before
    public void init() {
        userDao.addUser(user);
        userDao.addUser(anUser);

        message.setUserId(anUser.getUserId());
        message1.setUserId(user.getUserId());
        messageDao.addMessage(message);
        messageDao.addMessage(message1);

        messageRelease.setMessage(message);
        messageRelease1.setMessage(message1);
        messageRelease.setId(user.getUserId());
        messageRelease1.setId(anUser.getUserId());

        List<MessageRelease> list = new ArrayList<>();
        list.add(messageRelease);
        list.add(messageRelease1);
        messageReleaseDao.addMessageRelease(list);
    }

    @Test
    public void testMessageReleaseDao() {
        //messageReleaseDao.findMessageByMessageTitle("通知",0,2)
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public MessageReleaseDao getMessageReleaseDao() {
        return messageReleaseDao;
    }

    public void setMessageReleaseDao(MessageReleaseDao messageReleaseDao) {
        this.messageReleaseDao = messageReleaseDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
