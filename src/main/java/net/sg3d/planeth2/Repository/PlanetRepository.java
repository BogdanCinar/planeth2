package net.sg3d.planeth2.repository;

import net.sg3d.planeth2.model.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepository extends CrudRepository<Planet, Integer> {
    Planet findByName(String name);
}
