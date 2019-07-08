package br.com.triad.controller

import br.com.triad.MessagesFixture
import br.com.triad.service.DefaultMessagesService
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification


import static org.hamcrest.Matchers.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(controllers = MessageController.class)
class MessageControllerTest extends  Specification{


    @Autowired
    MockMvc mockMvc;

    @Autowired
    DefaultMessagesService defaultMessagesService = Mock(DefaultMessagesService)


    def "Send Messages between anonymous users and bots"()
    {
        def messageCreate = MessagesFixture.buildMessages()


        given:
        def jsonInputValue = """
                {
                 "timestamp":"2019-07-04T17:53:46.821Z",
                 "from":"36b9f842-ee97-11e8-9443-0242ac120002",
                 "to":"16edd3b3-3f75-40df-af07-2a3813a79ce9",
                 "text":"Oi! Como posso te ajudar? 43333"
                 }
                """
        defaultMessagesService.sendMessages(messageCreate)

        expect:
        mockMvc.perform(post("/messages").
                content(jsonInputValue).contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isCreated())

    }


    def "get messages for specific ID "()
    {
        def messageId = MessagesFixture.buildMessages()

        given:
        def message = defaultMessagesService.getMessageDTO(messageId.id)

        expect:
        mockMvc.perform(get("/messages/5d22c93dd5235f738eb76cb8")).
                andExpect(status().isOk()).
                andExpect(jsonPath('$.id',is(message.id))).
                andExpect(jsonPath('$.from',is(message.from))).
                andExpect(jsonPath('$.to',is(message.to)))
    }


}
