package com.wan.services;

import com.hzit.entity.Grade;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */
@Service
public interface GreadServices {

         List<Grade>  findall();
}
