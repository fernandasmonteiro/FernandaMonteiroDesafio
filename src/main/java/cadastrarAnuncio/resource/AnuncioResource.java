package cadastrarAnuncio.resource;


import cadastrarAnuncio.model.Anuncio;
import cadastrarAnuncio.repository.AnuncioRepository;
import cadastrarAnuncio.resource.dto.AnuncioDTO;
import cadastrarAnuncio.util.BigDecimalConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/anuncio")
public class AnuncioResource {

    @Autowired
    private BigDecimalConverter bigDecimalConverter;

    @Autowired
    private AnuncioRepository anuncioRepository;

    @GetMapping
    public List<Anuncio> listaDeAnuncios(){
        return anuncioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Anuncio cadastroDeAnuncio(@RequestBody @Valid AnuncioDTO anuncioDTO){

        LocalDate dataInicio = LocalDate.parse(anuncioDTO.getDataDeInicio(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataTermino = LocalDate.parse(anuncioDTO.getDataDoTermino(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Anuncio anuncio = new Anuncio();
        anuncio.setAnuncioNome(anuncioDTO.getAnuncioNome());
        anuncio.setAnuncioCliente(anuncioDTO.getAnuncioCliente());
        anuncio.setDataDeInicio(dataInicio);
        anuncio.setDataDoTermino(dataTermino);
        anuncio.setValorInvestido(bigDecimalConverter.converter(anuncioDTO.getValorInvestido()));

        return anuncioRepository.save(anuncio);

    }

}
