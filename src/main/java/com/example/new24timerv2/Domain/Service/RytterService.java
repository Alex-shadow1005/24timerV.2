package com.example.new24timerv2.Domain.Service;


import com.example.new24timerv2.Domain.Model.RytterModel;
import com.example.new24timerv2.Reposetory.RytterReposetory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RytterService {

    private final RytterReposetory rytterReposetory;



    @Autowired
    public RytterService(RytterReposetory rytterReposetory) {
        this.rytterReposetory = rytterReposetory;
    }

    //read all
    public List<RytterModel> readbikerList(){
        return rytterReposetory.findAll();
    }

    /* public Optional<List<rytterModel>> readbikerbyteam(String hold){
         return rytterRepo.findAll().stream().filter(rytterModel-> rytterModel.gethold() != null && rytterModel.gethold() == holdnavn);
     }

     */
    //read one ById
    public Optional<RytterModel> readbiker(Long id){
        return rytterReposetory.findById(id);
    }
    //create
    public void create(RytterModel model){
        rytterReposetory.save(model);
    }
    //update
    public RytterModel update(RytterModel model){

        return rytterReposetory.save(model);
    }
    //delete
    public void delete(Long id){
        rytterReposetory.deleteById(id);
    }


}


