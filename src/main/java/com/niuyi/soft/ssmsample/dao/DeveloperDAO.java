package com.niuyi.soft.ssmsample.dao;

import com.niuyi.soft.ssmsample.model.DeveloperModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 名称: DeveloperDAO
 * 作者: 牛毅
 * 日期: 2018/6/12 10:07
 * 描述: ${DESCRIPTION}
 */
public interface DeveloperDAO {

    List<DeveloperModel> getAllDevelopers();

    DeveloperModel getDeveloper(String developerId);

    boolean addDeveloper(DeveloperModel developer);

    boolean deleteDeveloper(String developerId);

    //想传入多个参数，需要使用@Param注解
    boolean updateDeveloper(@Param("developerId") String developerId, @Param("name") String name);

    //不用再编写DeveloperDAOImpl层，Myabtis帮助我们动态实现，我们需要编写mapper
}
