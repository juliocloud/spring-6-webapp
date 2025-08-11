package br.com.ojuliocode.spring_6_webapp.repositories;

import br.com.ojuliocode.spring_6_webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
