package org.ajou.realcoding.positioncrawler.positioncrawler.PositionService;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.positioncrawler.positioncrawler.api.OpenpositionApiClient;

import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Position;
import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Summoner;
import org.ajou.realcoding.positioncrawler.positioncrawler.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;

@org.springframework.stereotype.Service
@Slf4j
public class Service {
    // 전달해서 받은 값을 이제 여기서 레퍼지토리 불러서 거기서 저장시키고 or 업데이트 등등 하고  찾아와서 여기서 리턴.

    @Autowired
    OpenpositionApiClient openpositionApiClient;
    @Autowired
    PositionRepository positionRepository;

     List<Position> positionList = null;

     public Summoner summonerinfo (String summonerName)
     {
         return openpositionApiClient.requestSummoner(summonerName);
     }

    public List<Position> getPositionInfoByName(String summonerName)
    {
       String encryptedsummonerid =openpositionApiClient.requestSummoner(summonerName).getId();
       List<Position> position =  openpositionApiClient.requestPosition(encryptedsummonerid); //여기에 문제가 있는듯 json을 넘겨주는과정에서
      // String summonerId = position.getSummonerId();

       /* int flag=0;
        int i=0;
        for(Position position1 : position)
        {
          if(encryptedsummonerid==position.get(i).getSummonerId())
          {
              flag++;
          }
          i++;
        }
        if(flag==1) //있으면 update
        {
            positionRepository.updatePositionInfo(encryptedsummonerid,position.get(0));
        }
        else //없으면 insert
        {
            positionRepository.insertPositionInfo(position);
        }*/

       positionRepository.insertPositionInfo(position);
        return positionRepository.findPositionBySummonerNameInDB(encryptedsummonerid);
    }

}
