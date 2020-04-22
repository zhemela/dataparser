package com.example.dataparser.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Paging;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterFactoryConfig {

    @Value("${twitter.consumer.key}")
    private String consumerKey;
    @Value("${twitter.consumer.secret}")
    private String consumerSecret;
    @Value("${twitter.access.token}")
    private String accessToken;
    @Value("${twitter.access.token.secret}")
    private String accessTokenSecret;

    @Bean
    public twitter4j.conf.Configuration configuration() {
        return new ConfigurationBuilder()
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret)
                .build();
    }

    @Bean
    public TwitterFactory twitterFactory() {
        return new TwitterFactory(configuration());
    }

    @Bean
    public TwitterStreamFactory twitterStreamFactory() {
        return new TwitterStreamFactory(configuration());
    }

    @Bean
    public Paging paging() {
        return new Paging();
    }
}
