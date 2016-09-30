package com.wan.services.impl;

import com.hzit.entity.Grade;
import com.hzit.mapper.GradeMapper;
import com.wan.services.GreadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */
@Service
public class GresdServicesinpl implements GreadServices {
         @Autowired
       public GradeMapper gradeMapper;
         public List<Grade> findall(){


             return gradeMapper.searchGradeByParams(null);
         };
}
