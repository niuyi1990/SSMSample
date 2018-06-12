package com.niuyi.soft.ssmsample.controller;

import com.niuyi.soft.ssmsample.model.CommonModel;
import com.niuyi.soft.ssmsample.model.DeveloperModel;
import com.niuyi.soft.ssmsample.services.DeveloperService;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 名称: DeveloperController
 * 作者: 牛毅
 * 日期: 2018/6/12 10:07
 * 描述: ${DESCRIPTION}
 */
@Controller
@RequestMapping("/developer")
public class DeveloperController {

    @Autowired
    private DeveloperService service;

    @RequestMapping(value = "/api/developer/addDeveloper", method = RequestMethod.POST)
    @ResponseBody
    public CommonModel addDeveloper(String name, String site, String avatar) {
        System.out.println("name=" + name);
        System.out.println("site=" + site);
        System.out.println("avatar=" + avatar);

        DeveloperModel developer = new DeveloperModel();
        developer.setName(name);
        developer.setSite(site);
        developer.setAvatar(avatar);

        CommonModel commonModel = new CommonModel();

        if (service.addDeveloper(developer)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFail();
        }
        return commonModel;
    }

    @RequestMapping(value = "/api/developer/deleteDeveloper{developerId}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonModel deleteDeveloper(@PathVariable("developerId") String developerId) {
        System.out.println("developerId=" + developerId);

        CommonModel commonModel = new CommonModel();

        if (service.deleteDeveloper(developerId)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFail();
        }
        return commonModel;
    }

    @RequestMapping(value = "/api/developer/updateDeveloper", method = RequestMethod.POST)
    @ResponseBody
    public CommonModel updateDeveoper(String developerId, String name) {
        System.out.println("developerId=" + developerId);
        System.out.println("name=" + name);

        CommonModel commonModel = new CommonModel();

        if (service.updateDeveloper(developerId, name)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFail();
        }
        return commonModel;
    }

    @RequestMapping(value = "/api/developer/getDeveloper", method = RequestMethod.GET)
    @ResponseBody
    public CommonModel getDeveloper(String developerId) {
        System.out.println("developerId=" + developerId);

        CommonModel commonModel = new CommonModel();

        DeveloperModel developer = service.getDeveloper(developerId);

        if (developer != null) {
            commonModel.setSuccess();
            commonModel.setData(developer);
        } else {
            commonModel.setFail();
        }
        return commonModel;
    }

    @RequestMapping(value = "/api/developer/getAllDeveloper", method = RequestMethod.GET)
    @ResponseBody
    public CommonModel getAllDevelopers() {
        CommonModel commonModel = new CommonModel();

        List<DeveloperModel> allDevelopers = service.getAllDevelopers();

        if (allDevelopers.size() > 0) {
            commonModel.setSuccess();
            commonModel.setData(allDevelopers);
        } else {
            commonModel.setFail();
        }
        return commonModel;
    }
}
