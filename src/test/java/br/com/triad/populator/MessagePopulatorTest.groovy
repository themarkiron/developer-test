package br.com.triad.populator

import br.com.triad.MessagesFixture
import br.com.triad.model.AnonymousModel
import br.com.triad.model.BotsModel
import org.springframework.boot.test.mock.mockito.SpyBean
import spock.lang.Specification

class MessagePopulatorTest extends Specification {

    @SpyBean
    MessagePopulator messagePopulator = Spy(MessagePopulator)

    def " test populate data"()
    {

        def messageModel = MessagesFixture.buildMessaagesModel()
        def messageDTO = MessagesFixture.buildMessages()

        given:
        messagePopulator.populate(messageModel,messageDTO)

        expect:
        messageDTO.id.is(messageModel.id)
        messageDTO.conversationId.is(messageModel.conversationModel.conversationId)
        messageDTO.getFrom().is(((BotsModel)messageModel.getFrom()).getId())
        messageDTO.getTo().is(((AnonymousModel)messageModel.getTo()).getId())
        messageDTO.getText().is(messageModel.getText())
    }


}
