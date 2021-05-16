package cadastrarAnuncio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anuncio")
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "anuncio_nome", nullable = false, length = 200)
    private String anuncioNome;

    @Column(name = "anuncio_cliente", nullable = false, length = 200)
    private String anuncioCliente;

    @Column(name = "data_de_inicio", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeInicio;

    @Column(name = "data_do_termino", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDoTermino;

    @Column(name = "valor_investido", nullable = false)
    private BigDecimal valorInvestido;

}
