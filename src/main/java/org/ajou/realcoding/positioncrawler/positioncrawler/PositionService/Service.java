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
       List<Position> position =  openpositionApiClient.requestPosition(encryptedsummonerid);

       if(positionRepository.testpossiblityofupdate(encryptedsummonerid))
       {

           positionRepository.updateOneinDB(encryptedsummonerid,position.get(0));
           //리스트에서 첫번째꺼 가져와서 업데이트 . 당연히 리스트에는하나있을거니까 첫번째 받아오는게 맞음.4

           //  System.out.println("start delete and reinserting");
           //positionRepository.deleteOneinDB(encryptedsummonerid);
           //positionRepository.insertPositionInfo(position);
       }
       else
       {
           System.out.println("start inserting");
           positionRepository.insertPositionInfo(position);
       }
        //positionRepository.insertPositionInfo(position);
        return positionRepository.findPositioninfoBySummonerNameInDB(encryptedsummonerid);
    }

}
