<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/28
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增页面</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>
<%--<form action="wanlun66" method="post" id="bdSubject">
           科目名称：<input type="text"    name="subjectName"/><br>
           课时数量：<input type="text"    name="classHour"/><br>
           所属班级：<input type="text"    name="gradeId"/><br>
                  <input type="submit"  value="提交"/>

</form>--%>


<table class=" table table-bordered"  style="width: 60%" align="center">
    <form  id="bd">
        <tr>
            <td align="center"><h3>新增科目</h3></td>
        </tr>

        <tr>
            <td><input type="text" class="form-control"  placeholder="科目名称"  value="subjectName" name="subjectName"></td>
        </tr>

        <tr>
            <td><input type="number" class="form-control"  placeholder="科目课时" value="classHour" name="classHour"></td>
        </tr>

        <tr>
            <td><input type="number" class="form-control"  placeholder="所属班级"  value="gradeId" name="gradeId"></td>
        </tr>
          <tr>
              <td align="right"><input  id="tijiao" type="button" class="btn btn-primary" value="增加科目"/></td>
          </tr>

    </form>
</table>

<div class="alert " id="msg"  style="width: 60%;margin: 10px auto" ></div>




</body>
<script>

                        $(function(){
                           $("#tijiao").click(function(){
                               $.post("wanlun66",$("#bd").serialize(),function(data){
                                   $("#msg").fadeIn(10);
                                   if(data==true){
                                       $("#msg").removeClass("alert alert-danger").addClass("alert alert-success")
                                       $("#msg").html("新增成功")
                                       location="wanlun77"
                                   }else{
                                       $("#msg").html("新增失败")
                                       $("#msg").removeClass("alert alert-success").addClass("alert alert-danger")
                                   }
                                   $("#msg").fadeOut(3000);
                               })
                           });
                        });
</script>
</html>
