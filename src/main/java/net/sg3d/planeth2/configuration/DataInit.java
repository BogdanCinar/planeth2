package net.sg3d.planeth2.configuration;

import net.sg3d.planeth2.model.Planet;
import net.sg3d.planeth2.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private PlanetRepository planetRepository;

    @Autowired
    public DataInit(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = planetRepository.count();
        if (count == 0) {
            Planet p1 = new Planet("Earth",0.9807d,6371d);
            planetRepository.save(p1);
        }
    }
}
