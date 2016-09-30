package com.wan.services;

import com.wan.mapper.Usermapper;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/26.
 */

@Service
public class UserServices {
   private Usermapper usermapper;


        public  UserServices(){
            System.out.println("UserServices对象被创建");
        }

        public void  findall(){
            System.out.println("业务逻辑层");
             usermapper.findall();
        }
}
