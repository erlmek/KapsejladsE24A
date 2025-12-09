package org.example.kapsejladse24a.model;

import org.example.kapsejladse24a.repository.ResultRepository;
import org.example.kapsejladse24a.repository.SailboatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResultTest {

    @Autowired
    SailboatRepository sailboatRepository;

    @Autowired
    ResultRepository resultRepository;


    @Test
    void saveResult() {

        Sailboat sailboat2 = new Sailboat();
        sailboat2.setBoatType(BoatType.SMALLERTHAN25);
        sailboat2.setName("Bæveren Test");
        sailboatRepository.save(sailboat2);

        assertEquals(3, sailboatRepository.findAll().size());


    }

    @Test
    void getOnsdage() {
        List<LocalDate> wednesdays = IntStream.rangeClosed(0, (int) ChronoUnit.WEEKS.between(LocalDate.of(2026,5,1).with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)), LocalDate.of(2026,10,1))).mapToObj(i -> LocalDate.of(2026,5,1).with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY)).plusWeeks(i)).collect(Collectors.toList());

    }

    @Test
    void getWednesdaysIn2025() {
        var obj = Stream.iterate(LocalDate.of(2025, 1, 1), date -> date.plusDays(1))
                .limit(365)
                .filter(date -> date.getDayOfWeek() == DayOfWeek.WEDNESDAY)
                .toList();
        System.out.println(obj.size());
    }


}
