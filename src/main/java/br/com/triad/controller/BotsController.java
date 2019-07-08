package br.com.triad.controller;

import br.com.triad.dto.BotsDTO;
import br.com.triad.service.DefaultBotsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/bots")
public class BotsController {



    @Autowired
    private DefaultBotsService defaultBotsService;


    @GetMapping(value = "/{id}")
    @ResponseBody
    @Cacheable("boots")
    public String getBotsPerId(@PathVariable String id) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        BotsDTO botsDTO = defaultBotsService.getBots(id);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(botsDTO);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void createBots(@RequestBody  BotsDTO botsDTO)
    {
        defaultBotsService.createBots(botsDTO);
    }


    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBots(@RequestBody BotsDTO botsDTO) throws  Exception
    {
        defaultBotsService.updateBots(botsDTO.getId(),botsDTO.getName());

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBotsForId(@PathVariable String id){

        defaultBotsService.deleteBots(id);

    }




}
