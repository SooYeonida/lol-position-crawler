package org.ajou.realcoding.positioncrawler.positioncrawler.controller;

import org.ajou.realcoding.positioncrawler.positioncrawler.PositionService.Service;
import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Position;
import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PositionController {

    @Autowired
    Service service;

    @GetMapping("/lol/summoner/v4/summoners/by-name/{summonerName}")
    public Summoner getSummonerInfo(@PathVariable String summonerName)
    {
        return service.summonerinfo(summonerName);
    }

    @GetMapping("/position-info-crawler/positions/by-name/{summonerName}")
    public List<Position> getPositioninfo(@PathVariable String summonerName) //List<position>
    {
        return service.getPositionInfoByName(summonerName);
    }

}
