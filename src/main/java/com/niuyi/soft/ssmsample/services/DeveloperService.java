package com.niuyi.soft.ssmsample.services;

import com.niuyi.soft.ssmsample.dao.DeveloperDAO;
import com.niuyi.soft.ssmsample.model.DeveloperModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 名称: DeveloperService
 * 作者: 牛毅
 * 日期: 2018/6/12 10:08
 * 描述: ${DESCRIPTION}
 */
@Service
@Transactional
public class DeveloperService {

    @Autowired
    private DeveloperDAO developerDAO;

    //增
    public boolean addDeveloper(DeveloperModel developer) {
        return developerDAO.addDeveloper(developer);
    }

    //删
    public boolean deleteDeveloper(String develperId) {
        return developerDAO.deleteDeveloper(develperId);
    }

    //改
    public boolean updateDeveloper(String developerId, String name) {
        return developerDAO.updateDeveloper(developerId, name);
    }

    //查一个
    public DeveloperModel getDeveloper(String developerId) {
        return developerDAO.getDeveloper(developerId);
    }

    //查所有
    public List<DeveloperModel> getAllDevelopers() {
        return developerDAO.getAllDevelopers();
    }
}
