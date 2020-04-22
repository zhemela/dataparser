package com.example.dataparser.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import twitter4j.*;

import java.util.LinkedList;
import java.util.List;

@Component
public class TwitterCollector {
    private TwitterFactory twitterFactory;
    private Paging paging;

    @Autowired
    ApplicationContext context;

    @Autowired
    public TwitterCollector setTwitterFactory(TwitterFactory twitterFactory) {
        this.twitterFactory = twitterFactory;
        return this;
    }

    @Autowired
    public TwitterCollector setPaging(Paging paging) {
        this.paging = paging;
        return this;
    }

    public List<Status> getAccountTimeline(String userAccount) throws TwitterException {
        List<Long> friendList = new LinkedList<>();
        Twitter twitter = twitterFactory.getInstance();
        long cursor =-1L;
        IDs ids;
        do {
            ids = twitter.getFollowersIDs(userAccount, cursor);
            for(long userID : ids.getIDs()){
                System.out.println(friendList.size() + " | " + userID);
                friendList.add(userID);
            }
            if(friendList.size() > 100) {
                System.out.println("WOOOW!");
            }
        } while((cursor = ids.getNextCursor())!=0 );
        return twitterFactory.getInstance().getUserTimeline(userAccount, paging);
//        return twitterFactory.getInstance().getFollowersList(userAccount, 0L);
    }
}
