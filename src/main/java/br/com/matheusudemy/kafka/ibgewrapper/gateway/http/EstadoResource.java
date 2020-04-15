package br.com.matheusudemy.kafka.ibgewrapper.gateway.http;

import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.CidadeJSON;
import br.com.matheusudemy.kafka.ibgewrapper.gateway.json.EstadoJSON;
import br.com.matheusudemy.kafka.ibgewrapper.services.cidade.ConsultarCidadePorCodigoService;
import br.com.matheusudemy.kafka.ibgewrapper.services.estado.ConsultarEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

    @Autowired
    private ConsultarEstadoService consultarEstadoService;

    @Autowired
    private ConsultarCidadePorCodigoService consultarCidadePorCodigoService;

    @GetMapping("/")
    public List<EstadoJSON> consultarEstados() {
        return consultarEstadoService.execute();
    }

    @GetMapping("/{id}/cidades/")
    public List<CidadeJSON> consultarCidades(@PathVariable("id") String estados) {
        return consultarCidadePorCodigoService.execute(estados);
    }
}
