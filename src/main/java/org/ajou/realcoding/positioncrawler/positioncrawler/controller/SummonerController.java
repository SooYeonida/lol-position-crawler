package org.ajou.realcoding.positioncrawler.positioncrawler.controller;

import org.ajou.realcoding.positioncrawler.positioncrawler.api.OpenpositionApiClient;
import org.ajou.realcoding.positioncrawler.positioncrawler.api.OpensummonerIdApiClient;
import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerController { //리퀘스트날리면 해당 함수에대한거 수행.

    @Autowired
    OpensummonerIdApiClient opensummonerIdApiClient;
    @Autowired
    OpenpositionApiClient openpositionApiClient;

 //   @GetMapping("/lol/summoner/v4/summoners/by-name/{summonerName}")
      public String getSummonerId(String summonerName) //path방식이 /이름 쓰는거. 원래 타임 summoner였음
      {
          Summoner summoner_info = opensummonerIdApiClient.requestSummonerId(summonerName);
        String usersummonerId = summoner_info.getId();
        return  usersummonerId;

      }//summoner api 호출해서 summonerid 리턴

}