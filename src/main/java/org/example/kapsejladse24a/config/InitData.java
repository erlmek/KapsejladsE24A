package org.example.kapsejladse24a.config;

import org.example.kapsejladse24a.model.BoatType;
import org.example.kapsejladse24a.model.Sailboat;
import org.example.kapsejladse24a.model.Result;
import org.example.kapsejladse24a.repository.ResultRepository;
import org.example.kapsejladse24a.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    SailboatRepository sailboatRepository;

    @Autowired
    ResultRepository resultRepository;

    @Override
    public void run(String... args) throws Exception {
        Sailboat sailboat = new Sailboat();
        sailboat.setBoatType(BoatType.LONGERTHAN40);
        sailboat.setName("F24");
        sailboatRepository.save(sailboat);

        Sailboat sailboat2 = new Sailboat();
        sailboat2.setBoatType(BoatType.SMALLERTHAN25);
        sailboat2.setName("Bæveren");
        sailboatRepository.save(sailboat2);

        Result result1 = new Result();
        result1.setSailboat(sailboat);
        result1.setPoint(1);
        result1.setPosition(1);
        resultRepository.save(result1);

        Result result2 = new Result();
        result2.setSailboat(sailboat2);
        result2.setPoint(1);
        result2.setPosition(1);
        resultRepository.save(result2);

    }




}
