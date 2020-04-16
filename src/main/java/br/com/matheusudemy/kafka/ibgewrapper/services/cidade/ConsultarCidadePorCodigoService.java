package br.com.matheusudemy.kafka.ibgewrapper.services.cidade;

import br.com.matheusudemy.kafka.ibgewrapper.gateway.feign.CidadeClient;
import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.CidadeJSON;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultarCidadePorCodigoService {

    @Cacheable(value = "cidade")
    public List<CidadeJSON> execute(String estado) {
        long tempoInicial = System.currentTimeMillis();

        CidadeClient cidadeClient = Feign.builder()
                .decoder(new GsonDecoder())
                .target(CidadeClient.class, "https://servicodados.ibge.gov.br");

        List<CidadeJSON> cidadeJsons = cidadeClient.get(estado);

        System.out.printf("%.3f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);

        return cidadeJsons;
    }
}