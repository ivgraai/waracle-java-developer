package com.waracle.repository;

import com.waracle.model.Cake;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ivgraai
 */
public interface CakeRepository extends CrudRepository<Cake, Long> {

    @Override
    List<Cake> findAll();

}
