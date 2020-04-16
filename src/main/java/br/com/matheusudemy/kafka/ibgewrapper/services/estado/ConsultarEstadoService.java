package br.com.matheusudemy.kafka.ibgewrapper.services.estado;

import br.com.matheusudemy.kafka.ibgewrapper.gateway.feign.EstadoCliente;
import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.EstadoJSON;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultarEstadoService {

    @Cacheable(value = "estado")
    public List<EstadoJSON> execute() {
        long tempoInicial = System.currentTimeMillis();

        EstadoCliente estadoClient = Feign.builder()
                .decoder(new GsonDecoder())
                .target(EstadoCliente.class, "https://servicodados.ibge.gov.br");

        List<EstadoJSON> list = estadoClient.get();

        System.out.printf("Dentro do Servico de estado: %.3f ms%n", (System.currentTimeMillis() - tempoInicial) / 1000d);
        return list;
    }

}
