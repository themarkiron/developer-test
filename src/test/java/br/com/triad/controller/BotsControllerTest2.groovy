package br.com.triad.controller

import br.com.triad.MessagesFixture
import br.com.triad.service.DefaultBotsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import org.springframework.http.MediaType


import static org.hamcrest.Matchers.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(controllers = BotsController.class )
class BotsControllerTest  extends  Specification{


    @Autowired
    MockMvc mockMvc

    @Autowired
    DefaultBotsService defaultBotsService = Mock(DefaultBotsService)


    def 'create bots controller'()
    {
        given:
        def jsonInputValue = """
            {
              "id": "190",
              "name": "bots_name"
            } 
            """
        def bots = MessagesFixture.buildAMessage()
        defaultBotsService.createBots(bots)

        expect:
        mockMvc.perform(post("/bots").
                content(jsonInputValue).contentType(MediaType.APPLICATION_JSON)).
                 andExpect(status().isCreated())


    }


    def 'get by specific id '()
    {
        def messageId = MessagesFixture.buildAMessage()

        given:
        defaultBotsService.getBots(messageId.id)


        expect:
        mockMvc.perform(get("/bots/5d22bfe9d5235f1fae19f01c"))
                .andExpect(status().isOk()).
                 andExpect(jsonPath('$.id',is(messageId.id))).
                 andExpect(jsonPath('$.name',is(messageId.name)))

    }


    def 'delete by especific id' ()
    {
        def messageId = MessagesFixture.buildAMessage();

        given:
        defaultBotsService.deleteBots(messageId.name)

        expect:
        mockMvc.perform(delete("/bots/5d22c00bd5235f2153069bf0")).
                andExpect(status().isOk())
    }





}

