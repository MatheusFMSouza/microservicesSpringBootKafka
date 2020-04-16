package br.com.matheusudemy.kafka.ibgewrapper.gateway.json;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstadoJSON implements Serializable{

    private Long id;
    private String sigla;
    private String nome;
    private RegiaoJSON regiao;

}