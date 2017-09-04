package com.fekpal.dao;

import com.fekpal.domain.MessageRelease;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by APone on 2017/8/24.
 * MessageReleaseDao接口
 */
@Repository
public interface MessageReleaseDao {

    /**
     * 根据消息id获得专属消息
     *
     * @param messageReleaseId int
     * @return MessageRelease
     */
    MessageRelease getMessageByMessageReleaseId(int messageReleaseId);

    /**
     * 根据用户id获得
     *
     * @param receiveId int
     * @param start     int
     * @param count     int
     * @return List
     */
    List<MessageRelease> getMessagesByUserId(int receiveId, int start, int count);


    /**
     * 根据标题查找专属消息
     *
     * @param messageTitle String
     * @param start        int
     * @param count        int
     * @return List
     */
    List<MessageRelease> findMessageByMessageTitle(String messageTitle, int receiveId, int start, int count);

    /**
     * 添加专属消息
     *
     * @param messageReleaseList List
     */
    void addMessageRelease(List<MessageRelease> messageReleaseList);

    /**
     * 更新消息
     *
     * @param messageRelease MessageRelease
     * @param integerList    List
     */
    void updateMessageRelease(MessageRelease messageRelease, List<Integer> integerList);

}
