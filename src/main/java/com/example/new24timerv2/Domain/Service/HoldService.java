package com.example.new24timerv2.Domain.Service;


import com.example.new24timerv2.Domain.Model.HoldModel;
import com.example.new24timerv2.Reposetory.HoldReposetory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoldService {
    private final HoldReposetory holdReposetory;


    @Autowired
    public HoldService(HoldReposetory holdReposetory) {
        this.holdReposetory = holdReposetory;
    }
    //read all
    public List<HoldModel> readteamList(){
        return holdReposetory.findAll();
    }
    //read one ById
    public Optional<HoldModel> readteam(Long id){
        return holdReposetory.findById(id);
    }
    //create
    public void create(HoldModel model){
        holdReposetory.save(model);
    }
    //update
    public HoldModel update(HoldModel model){
        return holdReposetory.save(model);
    }
    //delete
    public void delete(Long id){
        holdReposetory.deleteById(id);
    }

}
