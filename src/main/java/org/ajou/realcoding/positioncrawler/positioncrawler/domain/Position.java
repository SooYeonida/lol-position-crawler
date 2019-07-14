package org.ajou.realcoding.positioncrawler.positioncrawler.domain;


import lombok.Data;
import java.util.List;

@Data
public class Position {
    private String queueType;
    private  String  summonerName;
    private  boolean hotStreak;
    private  int wins;
    private  boolean veteran;
    private  int losses;
    private  String rank;
    private  String  leagueId;
    private  boolean inactive;
    private  boolean freshBlood;
    private  String tier;
    private  String summonerId;
    private  int leaguePoints;
    private  MiniSeriesDTO miniSeriesDTO;

    //@Data
    public class MiniSeriesDTO
    {
        private String progress;
        private  int losses;
        private  int target;
        private  int wins;
    }
}
