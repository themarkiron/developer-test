package br.com.triad.controller;

import br.com.triad.dto.BotsDTO;
import br.com.triad.service.DefaultBotsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/bots")
@Api(value = "Bots Controller", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class BotsController {



    @Autowired
    private DefaultBotsService defaultBotsService;


    @GetMapping(value = "/{id}")
    @ResponseBody
    @Cacheable("boots")
    @ApiOperation("get specific bots for id")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "bots received with success"),
            @ApiResponse(code=404,message = "The id specific not exist")
    })
    public String getBotsPerId(@PathVariable String id) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        BotsDTO botsDTO = defaultBotsService.getBots(id);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(botsDTO);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create bots into  database")
    public  void createBots(@RequestBody  BotsDTO botsDTO)
    {
        defaultBotsService.createBots(botsDTO);
    }


    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("update specific bots per id")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "bots update with success"),
            @ApiResponse(code=404,message = "The id specific not exist to be update")
    })
    public void updateBots(@RequestBody BotsDTO botsDTO) throws  Exception
    {
        defaultBotsService.updateBots(botsDTO.getId(),botsDTO.getName());

    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("delete bots into  database per id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBotsForId(@PathVariable String id){

        defaultBotsService.deleteBots(id);

    }




}
