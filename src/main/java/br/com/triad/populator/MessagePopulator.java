package br.com.triad.populator;

import br.com.triad.dto.MessagesDTO;
import br.com.triad.model.AnonymousModel;
import br.com.triad.model.BotsModel;
import br.com.triad.model.MessageModel;
import org.springframework.stereotype.Service;

@Service
public class MessagePopulator {


    public void populate(MessageModel source, final MessagesDTO target )
    {


         target.setConversationId(source.getConversationModel().getConversationId());
         target.setId(source.getId());

         if(source.getFrom() instanceof BotsModel)
         {
             BotsModel botsModel = (BotsModel) source.getFrom();
             target.setFrom(botsModel.getId());
             target.setTo(((AnonymousModel) source.getTo()).getId());

         }
         else
         {
             AnonymousModel anonymousModel = (AnonymousModel) source.getFrom();
             target.setFrom(anonymousModel.getId());
             target.setTo(((BotsModel) source.getTo()).getId());

         }
         target.setText(source.getText());
         target.setTimestamp(source.getTimestamp());

    }
}
