<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<head>
<title>ADD DIGI FILES</title>
<link rel="stylesheet" href="login/css/bootstrap.min.css">
<link rel="stylesheet" href="login/css/bootstrap-theme.min.css">
<script src="login/js/jquery-1.11.3.min.js"></script>
<script src="login/js/bootstrap.min.js"></script>
<script src="login/js/validator.min.js"></script>
<link rel="stylesheet" href="login/css/my-block-ui.css">
<script src="login/js/my-block-ui.js"></script>
<style>
.form-horizontal .control-label {
   margin-bottom: 5px;
}
.form-horizontal .form-group {
    margin-bottom: 5px;
    margin-left:0px;
    margin-right:0px;
}
body {
  background:#f4f4f4;
}
</style>
</head>
<body>
<h3 style="color:red" align="center">${msg}</h3>
<%if(session.getAttribute("useremail")==null)
 {
	 response.sendRedirect("index.jsp");
 }
 else
 {
 %>

<div style="max-width:390px;padding:5px;margin:auto;">
<h2 style="text-align:center">ADD DIGI FILES</h2>
<div class="alert alert-danger" role="alert" id="errorField" style="display:none">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  <span class="sr-only">Error:</span>
  <span class="message"></span>
</div>
<div class="alert alert-success" role="alert" id="successField" style="display:none">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  <span class="sr-only">Success:</span>
  <span class="message"></span>
</div>
<form:form class="form-horizontal" id="formRegister" data-toggle="validator" role="form" commandName="uploadform" enctype="multipart/form-data">
  <div class="form-group">
    <label for="title" class="control-label">TITLE</label>
    <input name="title"  class="form-control" id="title"  placeholder="Enter title" data-error="Enter valid Title" required>
    <div class="help-block with-errors"></div>
  </div>
  <div class="form-group">
    <label for="inputFirstName" class="control-label">URL_FRONT_PAGE</label>
    <input type="file" name="file1"   class="form-control" id="file"  data-error="should not be null upload only png,jpeg,jpg files" required>
    <div class="help-block with-errors"></div>
  </div>
  <div class="form-group">
    <label for="inputLastName" class="control-label">URL_FRONT_PAGE</label>
    <input type="file" name="file2"   class="form-control" id="file"  data-error="should not be null upload only png,jpeg,jpg files" required>
    <div class="help-block with-errors"></div>
  </div>
  <div class="form-group">
    <label for="search" class="control-label">SEARCH TAGS</label>
    <input type="text"  name="search"  class="form-control" id="search" placeholder="Enter Search for Tags" data-error="should not be null" required>
    <div class="help-block with-errors"></div>
  </div>
   <input type="hidden" name="useremail" value="${loginForm.useremail}">
  <div class="form-group">
      <button style="width:100%" type="submit" class="btn btn-default btn-primary">ADD</button>
  </div>
</form:form>
<!-- <div id="blockUiDiv">
  <img src="wave.svg"/>
</div>
<div id="blockUiBackdrop">
</div>
</div>
<script>
$(function () {
	$('#formRegister').validator().on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
		    // handle the invalid form...
		  } else {
			  blockUi();
		    // everything looks good!
			  $.post("RegisterEmail", $( "#formRegister").serialize(), function( data ) {
				  var jdata = JSON.parse(data);
				  if(jdata.code == -1) {
					  $("#errorField .message").text(jdata.message);
					  $("#errorField").show();
					  $("#successField").hide();
				  } else {
					  $("#successField .message").text(jdata.message);
					  $("#errorField").hide();
					  $("#successField").show();
					  $("#formRegister").hide();
				  }
			  }).always(function() {
				  unBlockUi(); 
			  });  
		  }
		  return false;
    });
	  
});

</script>
</body>
</html> -->
<%} %>
</body>
</html>