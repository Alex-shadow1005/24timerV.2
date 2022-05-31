package com.example.new24timerv2.Controller;

import com.example.new24timerv2.Domain.Model.HoldModel;
import com.example.new24timerv2.Domain.Service.HoldService;
import com.example.new24timerv2.Reposetory.HoldReposetory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;

class HoldControllerTest {


@Autowired
private HoldReposetory holdReposetory;

    @Test
    void readteam() throws Exception{
        HoldModel model = new HoldModel(1l,"test");
        holdReposetory.save(model);

        assertEquals(model.getHoldnavn(),holdReposetory.findById(1l).get().getHoldnavn());



    }
}