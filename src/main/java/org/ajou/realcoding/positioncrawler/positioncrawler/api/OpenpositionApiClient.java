package org.ajou.realcoding.positioncrawler.positioncrawler.api;


import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Position;
import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OpenpositionApiClient {
    private  final String appid1 = "RGAPI-8239af97-8310-4229-97df-e25be9a0f818";
    private  final String openPositionUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={appid}";

    @Autowired
    RestTemplate restTemplate; //http통신에 쓰임 restful.

    public List<Position> requestPosition(String encryptedSummonerId)
    {
       return restTemplate.exchange(openPositionUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Position>>() {
       }, encryptedSummonerId, appid1).getBody();

    }
}