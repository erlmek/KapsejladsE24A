package org.example.kapsejladse24a.config;

import org.example.kapsejladse24a.model.BoatType;
import org.example.kapsejladse24a.model.Sailboat;
import org.example.kapsejladse24a.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    SailboatRepository sailboatRepository;

    @Override
    public void run(String... args) throws Exception {
        Sailboat sailboat = new Sailboat();
        sailboat.setBoatType(BoatType.LONGERTHAN40);
        sailboat.setName("F24");
        sailboatRepository.save(sailboat);
    }

}
