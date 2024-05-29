package com.example.demo.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class RunController {
     private  final RunRepository runRepository;

     public RunController(RunRepository runRepository){
         this.runRepository = runRepository;
     }

    @GetMapping("/")
    String helloRunners(){
        return "Hello dear runners welcome to astonishing journey";
    }

    @GetMapping("/api/v1/runs")
    List<Run> runs(){
        return runRepository.findAll();
    }

    @GetMapping("api/v1/runs/{id}")
    Run findById(@PathVariable("id") int id){
         Optional<Run> run =  runRepository.findById(id);

         if(run.isEmpty()){
//           throw  new RunNotFoundException();
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found");
         }

         return run.get();
    }
}
