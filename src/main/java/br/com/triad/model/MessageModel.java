package br.com.triad.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Data
@Document(collection = "messages")
public class MessageModel<T> {


    @Id
    private String id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    private T from;
    private T to;
    private String text;
    private  ConversationModel conversationModel;


}
