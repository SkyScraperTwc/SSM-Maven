<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>雇员修改</title>
</head>   
<body>     
			<form action="/Test-SSM-Maven/employee/edit" method="post">
		     	 <input type="hidden" name="id" value="${employee.id }"/>
		     	 <table title="雇员修改" align="center" border="1">
		     	 <caption>雇员修改</caption>
		     	 <tr> 
						<td>姓名：</td>  
						<td>
							<input type="text" name="last_name" value="${employee.name }"/>
						</td>
				 </tr>   
				 <tr> 
						<td>邮箱：</td>
						<td>
							<input type="text" name="email" value="${employee.email }"/>
						</td> 
				  </tr>
				 <tr>
					 <td>性别：</td>
					 <td>
						 <input type="text" name="gender" value="${employee.gender }"/>
					 </td>
				 </tr>
				  <tr>
						<td colspan="2">
						  <input type="submit" value="submit"/>     
						</td>
				   </tr>
				 </table> 
			</form> 
</body>    
</html>               