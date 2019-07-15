package org.ajou.realcoding.positioncrawler.positioncrawler.repository;


import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.positioncrawler.positioncrawler.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Slf4j
@Repository
public class PositionRepository{ //db에 저장하고 찾는 부분.
    //여기서 가산점부분 구현할 수 있을듯.

    @Autowired
    MongoTemplate mongoTemplate;

    //List<position>으로 주고받기보다는 나중에 디비에서 찾을때 list로 만드는게 좋을 것 같음
    public void insertPositionInfo(List<Position> position)
    {
        mongoTemplate.insert(position,Position.class );
    }//게임성적정보를 db에 저장

    public void updatePositionInfo(String summonerId, Position position)
    {
     Query query = Query.query(Criteria.where("summmonerId").is(summonerId));
        Update update = new Update();

        update.set("wins",position.getWins());
        update.set("losses",position.getLosses());
        update.set("rank",position.getRank());
        update.set("tier",position.getTier());
        update.set("leaguePoints",position.getLeaguePoints());
        mongoTemplate.updateFirst(query,update,Position.class);
    }
  
    public List<Position> findPositionBySummonerNameInDB(String summonerId) //db에서 맞는 summoner이름 찾아서 게임성적정보 값리턴.
    {
        Query query = Query.query(Criteria.where("summonerId").is(summonerId)); //summonerId?
        return mongoTemplate.find(query,Position.class);

    }//소환사이름으로 db에서 성적정보 찾아서 넘겨줌.



}
