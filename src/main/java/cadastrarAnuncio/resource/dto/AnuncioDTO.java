package cadastrarAnuncio.resource.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AnuncioDTO {


    private String anuncioNome;


    private String anuncioCliente;


    private String dataDeInicio;


    private String dataDoTermino;


    private String valorInvestido;
}
