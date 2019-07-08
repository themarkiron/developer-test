package br.com.triad.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "bots")
public class BotsModel {

    @Id
    private String id;
    private String name;
    private String identify = "36b9f842-ee97-11e8-9443-0242ac120002";
}
