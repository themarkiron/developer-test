package br.com.triad.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Document(collection = "conversation")
public class ConversationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String conversationId;
    private MessageModel messageModel;
    private BotsModel botsModel;
    private AnonymousModel anonymousModel;
    private String text;
}
