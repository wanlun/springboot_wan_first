<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/26
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title></title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootcss.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <style>
     .tb{
          width: 80%;
          margin: 20px auto;
          border: 1px solid lavender;
     }
    .fenye{
          width: 300px;
          text-align: center;
          margin: 20px auto;
           font-size: 13px;
    }
    </style>
</head>
<body>

                 <table class="table table-striped table-hover tb" >
                     <tr>
                         <td>科目编号</td>
                         <td>科目名称</td>
                         <td>科目课时</td>
                         <td>教师ID</td>
                         <td>编辑</td>
                         <td>删除</td>
                     </tr>
                     <c:forEach items="${requestScope.list}" var="subject">
                     <tr>
                         <td><input type="checkbox" value="${subject.subjectNo}"/>${subject.subjectNo}</td>
                         <td>${subject.subjectName}</td>
                         <td>${subject.classHour}</td>
                         <td>${subject.gradeId}</td>
                         <td><a type="button" href="updetaSubject?subjectNo=${subject.subjectNo}" class="btn btn-info" >编辑</a></td>
                         <td><button type="button"  href="deleteSubject" class="btn btn-danger" title="${subject.subjectNo}">删除</button></td>
                     </tr>
                     </c:forEach>
                     <tr >
                         <td colspan="6">
                           <button type="button" class="btn btn-success">全选</button>
                         <a type="button" href="xingzeng" class="btn btn-info" >新增</a>
                           <button type="button" class="btn btn-danger" >删除</button>
                         </td>
                     </tr>
                 </table>
                 <div class="fenye">
                 <nav>
                     <ul class="pagination">
                         <li><a href="wanlun77?page=${page-1}">&laquo;</a></li>

                          <c:forEach var="d" begin="0" end="${yesh-1}">
                              <li><a href="wanlun77?page=${d}">${d+1}</a></li>
                          </c:forEach>
                         <li><a href="wanlun77?page=${page+1}">&raquo;</a></li>
                     </ul>
                 </nav>
                 </div>
</body>

<script>
       $(function(){
          $(".btn-danger").click(function(){
               var subjectNo=$(this).attr("title");
            if(confirm("您确定要删除")){
                $.post("deleteSubjectno",{subjectNo:subjectNo},function(data){
                    if(data==1){
                        alert("删除成功");
                        location.reload();
                    }else
                    {
                        alert("删除失败");
                    }
                })
            }

          });
       });
</script>
</html>
