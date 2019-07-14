package org.ajou.realcoding.positioncrawler.positioncrawler.repository;


import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Slf4j
@Repository
public class PositionRepository{ //db에 저장하고 찾는 부분.
    //여기서 가산점부분 구현할 수 있을듯.

    @Autowired
    MongoTemplate mongoTemplate;

    public void insertPositionInfo(List<Position> position)
    {
        mongoTemplate.insert(position);
    }//게임성적정보를 db에 저장

    public List<Position> findPositionBySummonerNameInDB(String encryptedsummonerid) //db에서 맞는 summoner이름 찾아서 게임성적정보 값리턴.
    {
        Query query = Query.query(Criteria.where("summonerName").is(encryptedsummonerid)); //summonerName?
        return mongoTemplate.find(query,Position.class);

    }//소환사이름으로 db에서 성적정보 찾아서 넘겨줌.
}
