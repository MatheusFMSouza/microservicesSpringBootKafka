package br.com.matheusudemy.kafka.ibgewrapper.gateway.listener;


import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.CidadeJSON;
import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.CidadeList;
import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.EstadoRequestTopicJson;
import br.com.matheusudemy.kafka.ibgewrapper.services.cidade.ConsultarCidadePorCodigoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeListener {

    @Autowired
    private ConsultarCidadePorCodigoService consultarCidadePorCodigoService;

    @KafkaListener(topics = "${kafka.topic.request-topic-cidade}")
    public Message<String> execute(String in, @Header(KafkaHeaders.REPLY_TOPIC) byte[] replyTo,
                                   @Header(KafkaHeaders.CORRELATION_ID) byte[] correlation) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        EstadoRequestTopicJson json = mapper.readValue(in, EstadoRequestTopicJson.class);

        List<CidadeJSON> list = consultarCidadePorCodigoService.execute(json.getUf());

        String jsonReturn = mapper.writeValueAsString(CidadeList.builder().list(list).build());

        return MessageBuilder.withPayload(jsonReturn)
                .setHeader(KafkaHeaders.TOPIC, replyTo)
                .setHeader(KafkaHeaders.CORRELATION_ID, correlation)
                .build();

    }

}
