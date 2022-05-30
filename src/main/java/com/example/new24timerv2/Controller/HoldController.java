package com.example.new24timerv2.Controller;

import com.example.new24timerv2.Domain.Model.HoldModel;
import com.example.new24timerv2.Domain.Service.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/hold")

public class HoldController {


        private final HoldService holdService;

        @Autowired //dependency injektion
        public HoldController(HoldService holdService) {
            this.holdService = holdService;
        }

        @GetMapping
        public ResponseEntity<List<HoldModel>> readteamList() {
            List<HoldModel> teamlist = holdService.readteamList();
            return new ResponseEntity<>(teamlist, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public HoldModel readteam(@PathVariable Long id) {
            Optional<HoldModel> readteam = holdService.readteam(id);
            return readteam.orElse(null);
        }


        @PostMapping
        public ResponseEntity<HoldController> createHold(@RequestBody HoldModel model){
            holdService.create(model);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<HoldModel> update(@PathVariable Long id, @RequestBody HoldModel model){
            model.setId(id);
            return new ResponseEntity<>(holdService.update(model),HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<HoldModel> delete(@PathVariable Long id){
            holdService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }




