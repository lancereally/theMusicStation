package org.lanqiao.controller;

import org.lanqiao.entity.Share;
import org.lanqiao.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShareController {

    @Autowired
    ShareService shareService;

    @RequestMapping("/share/getAllShare")
    public List<Share> get(){
        List<Share> shareList = shareService.getAllShare();
        return shareList;
    }


}
