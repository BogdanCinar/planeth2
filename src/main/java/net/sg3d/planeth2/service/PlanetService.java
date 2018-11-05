package net.sg3d.planeth2.service;

import net.sg3d.planeth2.model.Planet;
import net.sg3d.planeth2.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    static final Double G_CONSTANT = 6.6726d;

    public List<Planet> getAllPlanets() {
        List<Planet> planets = new ArrayList<Planet>();
        planetRepository.findAll().forEach(planet -> planets.add(planet));
        return planets;
    }

    public Planet getPlanetById(int id) {
        return planetRepository.findById(id).get();
    }

    public Planet getPlanetByName(String name) {
        return planetRepository.findByName(name);
    }

    public void saveOrUpdate(Planet planet) {
        planetRepository.save(planet);
    }

    public void delete(int id) {
        planetRepository.deleteById(id);
    }

    public Double getMassForPlanet(String name) {
        Planet p = planetRepository.findByName(name);
        return p.getGravity() * p.getRadius() * p.getRadius() / G_CONSTANT;
    }
}
