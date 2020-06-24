package br.com.tga.kafka.consumer;

import java.util.Random;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.tga.kafka.producer.Client;


@Component
public class ClienteConsumer {
    
    @KafkaListener(topics = "spec2-tiago-galvao-2", groupId = "42154843832")
    public void receber(@Payload Client client){

        Random random = new Random();
        
        if(random.nextBoolean()){
            String log = "Cliente %s e porta %s";
            String result = String.format(log, client.getClient(), client.getPort());
            ManipulaExcel.escreveLog(log);
            System.out.println(result);    
        }else{
            System.out.println("Cliente não liberado");
        }
   }
}