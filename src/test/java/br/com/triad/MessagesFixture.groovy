package br.com.triad

import br.com.triad.dto.BotsDTO
import br.com.triad.dto.MessagesDTO
import br.com.triad.model.AnonymousModel
import br.com.triad.model.BotsModel
import br.com.triad.model.ConversationModel
import br.com.triad.model.MessageModel

class MessagesFixture {


        static def buildAMessage()
        {
            return new BotsDTO(id: "5d22bfe9d5235f1fae19f01c",name: "bots_name")
        }


        static def buildMessages()
        {
            return new MessagesDTO(id: "5d22c93dd5235f738eb76cb8",conversationId: "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
                    timestamp: new Date(),from: "36b9f842-ee97-11e8-9443-0242ac120002",to: "16edd3b3-3f75-40df-af07-2a3813a79ce9",text: "Ola como posso ajudar  ?")
        }

       static buildBotsModel()
       {
           BotsModel botsModel = new BotsModel()
           botsModel.setId("212121")
           botsModel.setName("test")

           return botsModel
       }

    static buildMessaagesModel()
    {
        MessageModel messageModel = new MessageModel()
        messageModel.setId("12212")
        messageModel.setConversationModel( new ConversationModel())
        messageModel.getConversationModel().setConversationId("121212121")
        messageModel.setFrom(new BotsModel())
        ((BotsModel)messageModel.getFrom()).setId("sasasa")
        messageModel.setTo(new AnonymousModel())
        ((AnonymousModel)messageModel.getTo()).setId("545454")
        messageModel.setText("oi posso ajudar ?")
        messageModel.setTimestamp(new Date())


        return messageModel


    }
    }



