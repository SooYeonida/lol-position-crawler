package org.ajou.realcoding.positioncrawler.positioncrawler.domain;


//import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Position {
  //  @JsonProperty("queueType")
    private String queueType;
    //@JsonProperty("summonerName")
    private  String  summonerName;
    //@JsonProperty("hotStreak")
    private  boolean hotStreak;
   // @JsonProperty("wins")
    private  int wins;
   // @JsonProperty("veteran")
    private  boolean veteran;
   // @JsonProperty("losses")
    private  int losses;
   // @JsonProperty("rank")
    private  String rank;
    //@JsonProperty("leagueId")
    private  String  leagueId;
   // @JsonProperty("inactive")
    private  boolean inactive;
   // @JsonProperty("freshBlood")
    private  boolean freshBlood;
    //@JsonProperty("tier")
    private  String tier;
   // @JsonProperty("summonerId")
    private  String summonerId;
    //@JsonProperty("leaguePoints")
    private  int leaguePoints;
    private  MiniSeriesDTO miniSeriesDTO;

   @Data
    public static class MiniSeriesDTO
    {
      //  @JsonProperty("progress")
        private String progress;
        //@JsonProperty("losses")
        private  int losses;
        //@JsonProperty("target")
        private  int target;
        //@JsonProperty("wins")
        private  int wins;
    }
}
