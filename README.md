# BOTS API 

An API to sent messages and save in mongo DB 


# Requirements
[JDK 8] - Minimum version of Java JDK 8 </br>
MongoDB installed in your machine



# Build project

./gradlew clean build bootRun

# Swagger UI

http://localhost:8080/swagger-ui.html

# How to Test API 

* First you need to mass of data , so.

<b>
1-) Create bots 
</b>
</br>
</br>
</br>
  
<i>
{
  "id": "string",
  "name": "string"
}
 </i>
 </br>
 </br>
 </br>

<b>
2-) Create message bots 
</b>
</br>
</br>
</br>
<i>
{
  "timestamp": "2019-07-04T17:53:46.821Z",
 "from": "36b9f842-ee97-11e8-9443-0242ac120002",
 "to": "16edd3b3-3f75-40df-af07-2a3813a79ce9",
 "text": "Oi! Como posso te ajudar?"
}
</i>
</br>
</br>
</br>

<b>
3-) Create message anonymous
</b>
</br>
</br>
</br>
<i>
{
  "timestamp": "2019-07-04T17:53:46.821Z",
 "from": "16edd3b3-3f75-40df-af07-2a3813a79ce9",
 "to": "36b9f842-ee97-11e8-9443-0242ac120002",
 "text": "Sim , claro que pode "
}
</i>
</br>
</br>


* Second , now you can get  information to ID
</br>
</br>


<b>
1-) curl -X GET --header "Accept: */*" "http://localhost:8080/bots/5d1e3b1f52eec84522e82546"
  
</b>
</br>
</br>

* You  receive bots  output like this.
</br>
</br>

  <i>
{
  "id" : "5d1e3b1f52eec84522e82546",
  "name" : "string"
}

</i>
</br>
</br>


<b> 2-) curl -X GET --header "Accept: */*" "http://localhost:8080/messages/5d22cdbdd5235f25e0bfd86f"
 </b>
 </br>
 </br>

 
 * You  receive message output like this.
 </br>
 </br>

 <i>
 {
  "id" : "5d22cdbdd5235f25e0bfd86f",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561981294,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22cdbdd5235f25e0bfd86e",
  "text" : "Ola como posso ajudar  ?"
}
 </i>
 </br>
 </br>

 <b>
 3-) curl -X GET --header "Accept: */*" "http://localhost:8080/messages?conversationId=7665ada8-3448-4acd-a1b7-d688e68fe9a1"
</b>
</br>

 * You  receive conversations output like this.
 </br>
 
 <i>
  
  [ {
  "id" : "5d1e872252eec82d96057b0d",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562262826821,
  "from" : "5d1e708552eec84c6dab8987",
  "to" : "5d1e3b1f52eec84522e82546",
  "text" : "Quero ajuda !! por favor "
}, {
  "id" : "5d1e872d52eec82d96057b10",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562262826821,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d1e872d52eec82d96057b0f",
  "text" : "Oi! Como posso te ajudar? 43333"
}, {
  "id" : "5d22c93dd5235f738eb76cb8",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562560829125,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22c93dd5235f738eb76cb7",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22c95fd5235f7447ef86d1",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562560848445,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22c95cd5235f7447ef86d0",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22c9a1d5235f76da8ac253",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562560922691,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22c9a0d5235f76da8ac252",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22c9f0d5235f79d83903a7",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562262826821,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22c9f0d5235f79d83903a6",
  "text" : "Oi! Como posso te ajudar? 43333"
}, {
  "id" : "5d22cad8d5235f03dc689938",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561240662,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22cad8d5235f03dc689937",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22caf7d5235f053e15aa45",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561271550,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22caf7d5235f053e15aa44",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22cb39d5235f088153e732",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561336913,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22cb39d5235f088153e731",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22cb73d5235f0ac3749899",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561395814,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22cb73d5235f0ac3749898",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22cc70d5235f1685285cc9",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561648798,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22cc70d5235f1685285cc8",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22cc96d5235f19a8c5ad5e",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561686729,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22cc96d5235f19a8c5ad5d",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22ccd7d5235f1d190e1eaf",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561751209,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22ccd7d5235f1d190e1eae",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22cd4dd5235f220e0e4eb5",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561869219,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22cd4dd5235f220e0e4eb4",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22cd8ad5235f2433c0268e",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561930439,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22cd8ad5235f2433c0268d",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22cdbdd5235f25e0bfd86f",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562561981294,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22cdbdd5235f25e0bfd86e",
  "text" : "Ola como posso ajudar  ?"
}, {
  "id" : "5d22cdbdd5235f25e0bfd872",
  "conversationId" : "7665ada8-3448-4acd-a1b7-d688e68fe9a1",
  "timestamp" : 1562262826821,
  "from" : "5d1e3b1f52eec84522e82546",
  "to" : "5d22cdbdd5235f25e0bfd871",
  "text" : "Oi! Como posso te ajudar? 43333"
} ]

</i>











