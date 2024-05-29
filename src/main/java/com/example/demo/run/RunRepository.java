package com.example.demo.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs =  new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional <Run> findById(Integer id){
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    @PostConstruct
    private void init(){
        runs.add(new Run( 1,
                "Monday morning run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                3, Location.INDOOR));

        runs.add(new Run( 2,
                "Monday morning run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(45),
                3, Location.INDOOR));


        runs.add(new Run( 3,
                "Monday morning run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(60),
                3, Location.INDOOR));
    }
}