package net.sg3d.planeth2.controller;

import net.sg3d.planeth2.model.Planet;
import net.sg3d.planeth2.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets/")
public class PlanetController {
    @Autowired
    PlanetService planetService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    private List<Planet> getAllPlanets() {
        return planetService.getAllPlanets();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "id/{id}")
    private Planet getPlanet(@PathVariable("id") int id) {
        return planetService.getPlanetById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "name/{name}")
    private Planet getPlanetByName(@PathVariable("name") String name) {
        return planetService.getPlanetByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "mass/name/{name}")
    private ResponseEntity<Double> getMassForPlanet(@PathVariable("name") String name) {
        Double mass = planetService.getMassForPlanet(name);

        if (mass != null) {
            return new ResponseEntity<>(mass, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mass, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", path = "id/{id}")
    private void deletePlanet(@PathVariable("id") int id) {
        planetService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    private int savePlanet(@RequestBody Planet planet) {
        planetService.saveOrUpdate(planet);
        return planet.getId();
    }
}
