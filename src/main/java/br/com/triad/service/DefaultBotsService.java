package br.com.triad.service;

import br.com.triad.dto.BotsDTO;
import br.com.triad.model.BotsModel;
import br.com.triad.populator.BotsPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class DefaultBotsService {


    @Autowired
    private BotsPopulator botsPopulator;


    @Autowired
    private MongoTemplate mongoTemplate;

    public void createBots(BotsDTO botsDTO)
    {
        BotsModel botsModel = new BotsModel();
        botsModel.setName(botsDTO.getName());
        mongoTemplate.insert(botsModel);
    }


    public BotsDTO getBots(String id )
    {
        BotsModel botsModel = mongoTemplate.findById(id,BotsModel.class);
        BotsDTO botsDTO =  null;
        if(botsModel != null) {
            botsDTO = new BotsDTO();
            botsPopulator.populate(botsDTO, botsModel);
        }
        return botsDTO;
    }


    public void updateBots(String id,String name) throws Exception {

        BotsModel botsModel = mongoTemplate.findById(id,BotsModel.class);
        if(botsModel != null) {
            botsModel.setName(name);
            mongoTemplate.save(botsModel);
        }else throw new Exception("Bots not found for update ");
    }


    public void deleteBots(String id)
    {
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)),BotsModel.class);
    }
}
