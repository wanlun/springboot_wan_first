package com.wan.controller;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.PageRequest;
import com.hzit.entity.Grade;
import com.hzit.entity.Subject;
import com.hzit.mapper.GradeMapper;
import com.hzit.mapper.SubjectMapper;
import com.wan.services.GreadServices;
import com.wan.services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@Controller
public class SubjectControllert {

         @Autowired
      SubjectServices subjectServices;
          @Autowired
      private SubjectMapper subjectMapper;
    @Autowired
    public GradeMapper gradeMapper;
      @Autowired
      GreadServices greadServices;
                @RequestMapping("/ww")
                @ResponseBody
                public  Object getdate(){
                    System.out.println("wan");
                    return subjectServices.findall();
                }

                    @RequestMapping("/wanlun77777")
                    public  String  getpage(ModelMap modelMap){
                        List<Subject> data=subjectServices.findall();
                         modelMap.put("data",data);
                        return "index";
                    }



                    @RequestMapping("/wanlun7")
                    public Page<Subject> pagefind(int page,int rowconut){
                        PageRequest pr=new PageRequest(page,rowconut);
                        Page<Subject>   data1=subjectMapper.searchSubjectByParams(null, pr);
                          return data1;
                    }




    @RequestMapping("/wanlun77")
    public  String  page(@RequestParam(name="page",defaultValue="0")Integer page,ModelMap modelMap){
        if(page<=0){page=0;}
           Page<Subject> data=subjectServices.findpage(page,15);
               List<Subject>  list=data.getContent();
        System.out.println(list.size());
               int yesh=data.getTotalPages();
        if (page>data.getTotalPages()-1){page=data.getTotalPages();}
            modelMap.put("list",list);
            modelMap.put("yesh",yesh);
            modelMap.put("page",page);
             return "index";
    }


       @RequestMapping("/xingzeng")
          public  String  xz(ModelMap modelMap){
           return "addSubject";
       }


     @RequestMapping("/wanlun66")
     @ResponseBody
     public  Boolean addSubject(Subject subject,ModelMap modelMap){
             boolean boo=subjectServices.addSubject(subject);
        if(boo==true){
            return true;
        }else
        {
            return false;
        }

    }

         /*这个是在点击删除之后，跳转到控制器上得页面*/

       @RequestMapping("/deleteSubject")
       public String deleteSubject(ModelMap modelMap){

           return "index";
       }


       /* 这个是AjAx操作之后对数据库的删除*/
       @RequestMapping("/deleteSubjectno")
       @ResponseBody
      public int deleteSubjectno(Integer subjectNo){
           int i=subjectServices.deletesubject(subjectNo);
            return i;
       }


       /* 这个实在点击编辑之后的跳的控制器的页面*/
         @RequestMapping("/updetaSubject")
       public String updateSuject(Integer subjectNo,ModelMap modelMap){
             Subject subject=subjectServices.findBySubjectNo(subjectNo);
             modelMap.put("subject",subject);
             List<Grade> data=greadServices.findall();
             modelMap.put("data",data);
              return "bianji";
         }


            /* 这是在是在修改之后的数进行控制操作*/
            @RequestMapping("/doupdatesSubject")
            @ResponseBody
         public  int deoupodateSubject(Subject subject){
                 int i=subjectServices.doupdate(subject);
                if(i==1)return i;
                else return -1;

            }

}
