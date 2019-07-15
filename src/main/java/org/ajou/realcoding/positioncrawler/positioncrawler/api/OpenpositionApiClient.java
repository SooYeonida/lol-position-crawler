package org.ajou.realcoding.positioncrawler.positioncrawler.api;


import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Position;
import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class OpenpositionApiClient {
    private  final String appid = "RGAPI-c34a14cc-87c8-4c69-802f-cb97c3e7119a";
    private  final String openPositionUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={appid}";
    private final String openSummonerUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={appid}";

    @Autowired
    RestTemplate restTemplate; //http통신에 쓰임 restful.

    public Summoner requestSummoner(String summonerName)
    {
        Summoner summonerinfo = restTemplate.exchange(openSummonerUrl, HttpMethod.GET,null,Summoner.class,summonerName,appid).getBody();
        return summonerinfo;
    }

    public List<Position> requestPosition(String encryptedSummonerId)
    {
       // ParameterizedTypeReference<List<Position>> myposition = new ParameterizedTypeReference<List<Position>>() {};
        ResponseEntity<List<Position>> response = restTemplate.exchange(openPositionUrl, HttpMethod.GET, null,new ParameterizedTypeReference<List<Position>>() {}, encryptedSummonerId, appid);
       List<Position> positionList =  response.getBody();
       return  positionList;

    }
}