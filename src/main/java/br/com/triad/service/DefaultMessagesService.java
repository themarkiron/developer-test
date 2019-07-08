package br.com.triad.service;

import br.com.triad.dto.MessagesDTO;
import br.com.triad.model.AnonymousModel;
import br.com.triad.model.BotsModel;
import br.com.triad.model.ConversationModel;
import br.com.triad.model.MessageModel;
import br.com.triad.populator.MessagePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultMessagesService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String BOTS_ID = "36b9f842-ee97-11e8-9443-0242ac120002";
    private static final String ANONYMOUS_ID = "16edd3b3-3f75-40df-af07-2a3813a79ce9";
    private static final String CONVERSATION_ID = "7665ada8-3448-4acd-a1b7-d688e68fe9a1";

    @Autowired
    private MessagePopulator messagePopulator;


    public void sendMessages(MessagesDTO messagesDTO)
    {
        MessageModel messageModel = new MessageModel();
        AnonymousModel anonymousModel =  mongoTemplate.findOne(new Query(Criteria.where("identify").is(messagesDTO.getFrom())),AnonymousModel.class);
        BotsModel botsModel =  mongoTemplate.findOne(new Query(Criteria.where("identify").is(messagesDTO.getFrom())),BotsModel.class);

        //TODO will be refactor after and applied to be dynamic informations
       // ConversationModel conversationModel = mongoTemplate.findOne(new Query(Criteria.where("botsModel.identify").is(BOTS_ID)),ConversationModel.class);
        //ConversationModel conversationAnonymous = mongoTemplate.findOne(new Query(Criteria.where("anonymousModel.identify").is(ANONYMOUS_ID)),ConversationModel.class);

        if(botsModel != null) {

            sentMessageBots(messagesDTO, messageModel, anonymousModel, botsModel);

        }
       else {
            if(anonymousModel != null) {
                sentMessageAnonymousUser(messagesDTO, messageModel, anonymousModel);

            }
        }

    }

    private void sentMessageAnonymousUser(MessagesDTO messagesDTO, MessageModel messageModel, AnonymousModel anonymousModel)
    {
        messageModel.setText(messagesDTO.getText());
        messageModel.setFrom(anonymousModel);
        messageModel.setTo(mongoTemplate.findOne(new Query(Criteria.where("identify").is(BOTS_ID)), BotsModel.class));
        messageModel.setTimestamp(messagesDTO.getTimestamp());
        mongoTemplate.insert(messageModel);

        messageModel.setConversationModel(new ConversationModel());
        messageModel.getConversationModel().setAnonymousModel(anonymousModel);
        messageModel.getConversationModel().setText(messagesDTO.getText());
        messageModel.getConversationModel().setConversationId(CONVERSATION_ID);

        mongoTemplate.insert(messageModel.getConversationModel());
        mongoTemplate.save(messageModel);
    }

    private void sentMessageBots(MessagesDTO messagesDTO, MessageModel messageModel, AnonymousModel anonymousModel, BotsModel botsModel)
    {
        messageModel.setText(messagesDTO.getText());
        messageModel.setTimestamp(messagesDTO.getTimestamp());
        messageModel.setFrom(botsModel);
        if(anonymousModel  == null) {
            AnonymousModel anonymous = new AnonymousModel();
            anonymous.setIdentify(ANONYMOUS_ID);
            mongoTemplate.insert(anonymous);
            messageModel.setTo(anonymous);
        }else {messageModel.setTo(anonymousModel);}

        mongoTemplate.insert(messageModel);


        messageModel.setConversationModel(new ConversationModel());
        messageModel.getConversationModel().setConversationId(CONVERSATION_ID);
        messageModel.getConversationModel().setAnonymousModel(anonymousModel);
        messageModel.getConversationModel().setBotsModel(botsModel);
        messageModel.getConversationModel().setText(messagesDTO.getText());

        mongoTemplate.insert(messageModel.getConversationModel());
        mongoTemplate.save(messageModel);
    }


    public  MessagesDTO getMessageDTO(String id)
    {
        MessageModel messageModel = mongoTemplate.findById(id,MessageModel.class);
        MessagesDTO messagesDTO = new MessagesDTO();
        messagePopulator.populate(messageModel,messagesDTO);

        return messagesDTO;
    }


    public  List<MessagesDTO> getConversations(String id)
    {
        List<MessageModel> messageModel = mongoTemplate.find(new Query(Criteria.where("conversationModel.conversationId").is(id)),MessageModel.class);
        List<MessagesDTO> messages = new ArrayList<>();
        messageModel.stream().forEach(message -> {
            MessagesDTO messagesDTO =  new MessagesDTO();
            messagePopulator.populate(message,messagesDTO);
            messages.add(messagesDTO);
        });

        return messages;
    }



}
