package br.com.triad.populator

import br.com.triad.MessagesFixture
import org.springframework.boot.test.mock.mockito.SpyBean
import spock.lang.Specification


class BotsPopulatorTest extends  Specification {


    @SpyBean
    BotsPopulator botsPopulator = Spy(BotsPopulator)

    def "test populate datas "()
    {
        def botsModel = MessagesFixture.buildBotsModel()
        def  botsdto = MessagesFixture.buildAMessage()

        given:
        botsPopulator.populate(botsdto,botsModel)

        expect:
        botsdto.id.is(botsModel.id)
        botsdto.name.is(botsModel.name)

    }
}
