package br.com.matheusudemy.kafka.ibgewrapper.gateway.listener;

import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.EstadoJSON;
import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.EstadoList;
import br.com.matheusudemy.kafka.ibgewrapper.services.estado.ConsultarEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.List;

public class EstadoListener {

    @Autowired
    private ConsultarEstadoService consultarEstadoService;

    @KafkaListener(topics = "${kafka.topic.request-topic}")
    @SendTo
    public EstadoList execute(){
        List<EstadoJSON> listEstados = consultarEstadoService.execute();

        return EstadoList.builder().list(listEstados).build();
    }
}
