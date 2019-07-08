package br.com.triad.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "anonymous")
public class AnonymousModel {

    @Id
    private String id;
    private String identify  = "16edd3b3-3f75-40df-af07-2a3813a79ce9";


}
