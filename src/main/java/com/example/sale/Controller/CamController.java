package com.example.sale.Controller;

import com.example.sale.Model.Campaign;
import com.example.sale.Model.Dto.CamDto;
import com.example.sale.Services.CamServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class CamController {
    @Autowired
    public CamServ camServ;

    @PostMapping("createCampaign")
    public Campaign campaign(@RequestBody CamDto campaign) throws ParseException {
        return camServ.createcampaign(campaign);
    }
}
