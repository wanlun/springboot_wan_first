package com.wan.services;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.PageRequest;
import com.hzit.entity.Subject;
import com.hzit.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/27.
 */
@Service
public class SubjectServices {


    @Autowired
  private SubjectMapper subjectMapper;


      public List<Subject> findall(){
        System.out.println("业务逻辑类。实现业务类，依赖了数据访问"+subjectMapper);
         return  subjectMapper.searchSubjectByParams(null);
      }


    public Page<Subject> findpage(int page,int count){
        System.out.println("业务逻辑类。实现业务类，依赖了数据访问"+subjectMapper);
        PageRequest pr=new PageRequest(page,count);
        return  subjectMapper.searchSubjectByParams(null,pr);
    }



      public boolean addSubject(Subject subject) {
         try {
             boolean bool= subjectMapper.insertSubject(subject);
              return  true;
         }catch (Exception ex){
              ex.printStackTrace();
               return false;
         }
      }

        /*这是业务逻辑类的删除方法*/
    public  int deletesubject(Integer integer){
         try {
             int i=subjectMapper.deleteSubjectBySubjectNo(integer);
             return i;
         }catch (Exception ex){
               ex.printStackTrace();
             return -1;
         }
    }


          /*根据科目的ID查询科目的全部信息*/
        public  Subject  findBySubjectNo(Integer subject){

            Map  map=new HashMap();
                 map.put("subjectNo",subject);
               List<Subject> data=subjectMapper.searchSubjectByParams(map);
              if (data.size()==1)
               return  data.get(0);
              else return  null;
        }


         /*修改数据的方法*/
          public int doupdate(Subject subject){
               try{
                   int i=subjectMapper.updateSubject(subject);
                   return i;
               }catch (Exception ex){
                   ex.printStackTrace();
                   return -1;
               }
              
          }
}
