package org.ajou.realcoding.positioncrawler.positioncrawler.api;


import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpensummonerApiClient {

    private  final String appid = "RGAPI-f358621c-88f3-4045-a9cd-f2d63fd35e71";
    private  final String openSummonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name?q={summonerName}?api_key={appid}";

    @Autowired
    RestTemplate restTemplate; //http통신에 쓰임 restful.

    //여기부분 뭔지 모르겟음 그리고 여기서 id 받아오는거면 controller부분 필요있나?
    public Summoner requestSummonerId(String summonerName)
    {
        return restTemplate.exchange(openSummonerUrl, HttpMethod.GET,null,Summoner.class,summonerName,appid).getBody();
    }
}