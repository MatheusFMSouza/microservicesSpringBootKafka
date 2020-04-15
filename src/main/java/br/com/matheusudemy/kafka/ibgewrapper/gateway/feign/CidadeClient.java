package br.com.matheusudemy.kafka.ibgewrapper.gateway.feign;

import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.CidadeJSON;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface CidadeClient {
    //https://servicodados.ibge.gov.br/api/v1/localidades/estados/{UF}/municipios

    @RequestLine("GET /api/v1/localidades/estados/{UF}/municipios")
    List<CidadeJSON> get(@Param("UF") String uf);
}
