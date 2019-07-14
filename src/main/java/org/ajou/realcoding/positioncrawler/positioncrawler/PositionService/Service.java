package org.ajou.realcoding.positioncrawler.positioncrawler.PositionService;

import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.positioncrawler.positioncrawler.api.OpenpositionApiClient;
import org.ajou.realcoding.positioncrawler.positioncrawler.api.OpensummonerIdApiClient;
import org.ajou.realcoding.positioncrawler.positioncrawler.controller.PositionController;
import org.ajou.realcoding.positioncrawler.positioncrawler.controller.SummonerController;
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
    SummonerController summonerController;
    @Autowired
    PositionController positionController;
    @Autowired
    OpenpositionApiClient openpositionApiClient;
    @Autowired
    OpensummonerIdApiClient opensummonerIdApiClient;
    @Autowired
    PositionRepository positionRepository;
  //  List<String> positionList = null;

    public List<Position> getPositionInfoByName(String summonerName)
    {
       String encryptedsummonerid =summonerController.getSummonerId(summonerName);
        List<Position> positionList = null;
       positionList = openpositionApiClient.requestPosition(encryptedsummonerid);
        positionRepository.insertPositionInfo(positionList);
      // String summoner_id = position_info.getSummonerId();
        return positionRepository.findPositionBySummonerNameInDB(encryptedsummonerid);
    }

}
