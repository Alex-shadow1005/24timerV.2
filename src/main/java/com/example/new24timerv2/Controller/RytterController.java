package com.example.new24timerv2.Controller;



import com.example.new24timerv2.Domain.Model.RytterModel;
import com.example.new24timerv2.Domain.Service.RytterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/rytter")
public class RytterController {

    private final RytterService rytterService;

    @Autowired //dependency injektion
    public RytterController(RytterService rytterService) {
        this.rytterService = rytterService;
    }

    @GetMapping()
    public ResponseEntity<List<RytterModel>> readbikerList() {
        List<RytterModel> bikerlist = rytterService.readbikerList();
        return new ResponseEntity<>(bikerlist, HttpStatus.OK);
    }
   /* @GetMapping("/{hold")
    public ResponseEntity<List<rytterModel>> readbikerlistbyTeam(@PathVariable ("hold") String name ) {
        Optional<rytterModel> bikerlistbyteam = rytterService.readbikerbyteam(Long.valueOf(name));
        //List<rytterModel> bikerlist = rytterService.readbikerList();
        return new ResponseEntity<List<rytterModel>>(bikerlistbyteam,HttpStatus.OK);
    }

    */
/*
   /* @GetMapping("/{name}")
    public ResponseEntity<List<rytterModel>> readbikerlistTeam(@PathVariable String name) {
        List<rytterModel> bikerlist = rytterService.readbikerList();
        bikerlist.stream().filter(x -> bikerlist.contains(name));
        return new ResponseEntity<>(bikerlist, HttpStatus.OK);

    }

    */


    @GetMapping("/{id}")
    public RytterModel readbiker(@PathVariable Long id) {
        Optional<RytterModel> readbiker = rytterService.readbiker(id);
        return readbiker.orElse(null);
    }




    @PostMapping
    public ResponseEntity<RytterController> addBiker(@RequestBody RytterModel model){
        rytterService.create(model);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RytterModel> update(@PathVariable Long id, @RequestBody RytterModel model){
        model.setId(id);
        return new ResponseEntity<>(rytterService.update(model),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RytterModel> delete(@PathVariable Long id){
        rytterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
