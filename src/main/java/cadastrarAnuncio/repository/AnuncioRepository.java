package cadastrarAnuncio.repository;

import cadastrarAnuncio.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
}
