package br.com.matheusudemy.kafka.ibgewrapper.gateway.feign;

import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.EstadoJSON;
import feign.RequestLine;

import java.util.List;

public interface EstadoCliente {

    //https://servicodados.ibge.gov.br/api/v1/localidades/estados
    @RequestLine("GET /api/v1/localidades/estados")
    List<EstadoJSON> get();

}
