package org.ajou.realcoding.positioncrawler.positioncrawler.api;


import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpensummonerIdApiClient { //

    private final String appid2 = "RGAPI-8239af97-8310-4229-97df-e25be9a0f818";
    private final String openSummonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={appid}";

    @Autowired
    RestTemplate restTemplate; //http통신에 쓰임 restful.

    public Summoner requestSummonerId(String summonerName)
    {
        return restTemplate.exchange(openSummonerUrl, HttpMethod.GET,null,Summoner.class,summonerName,appid2).getBody();

    }
}