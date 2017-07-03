<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DIGI LOCKER</title>
<link href="search/search.css" rel="stylesheet" type="text/css">
    <!-- Bootstrap Core CSS -->
    <link href="success/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="success/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="success/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="success/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">
function loadXMLDoc()
{
var xmlhttp;
var k=document.getElementById("search").value;
var urls="pass.jsp?ver="+k;
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4)
    {
        //document.getElementById("err").style.color="red";
        document.getElementById("err").innerHTML=xmlhttp.responseText;
 
    }
  }
xmlhttp.open("GET",urls,true);
xmlhttp.send();
}
</script>
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="loginsuccess.jsp">DIGI LOCKER</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i><core:out value="${useremail}" /><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>

                        <li class="divider"></li>
                        <li>
                            <a href="<core:url value="logout.htm" />"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="<core:url value="loginsuccess.htm" />"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="<core:url value="addfiles.htm" />"><i class="fa fa-fw fa-bar-chart-o"></i>ADD DIGI FILE</a>
                    </li>
                    <li>
                        <a href="view.htm"><i class="fa fa-fw fa-table"></i> VIEW FILES</a>
                    </li>
                    <%-- <li>
                       <a href="edit.htm?email=${loginForm.useremail}"><i class="fa fa-fw fa-edit"></i>EDIT</a>
                    </li> --%>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div class="container">
	<div class="row">
           <div id="custom-search-input">
                            <div class="input-group col-md-12">
                                <input type="text" class="search-query form-control" name="search" id="search" placeholder="Search" width="90" height="30" onkeyup="loadXMLDoc();"/><span id="err"> </span>
                                <span class="input-group-btn">
                                    <button class="btn btn-danger" type="button">
                                        <span class=" glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>
	</div>
</div>
    <!-- /#wrapper -->
</div>


    <!-- jQuery -->
    <script src="success/js/jquery.js"></script>
    <script src="search/search.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="success/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="success/js/plugins/morris/raphael.min.js"></script>
    <script src="success/js/plugins/morris/morris.min.js"></script>
    <script src="success/js/plugins/morris/morris-data.js"></script>

</body>

</html>

