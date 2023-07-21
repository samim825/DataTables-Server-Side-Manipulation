<%@page import="java.util.ArrayList"%>
<%@ page import="com.example.crud.model.Student" %>
<%@ page import="org.springframework.data.domain.Page" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <!--  DataTables file-->
    <link rel='stylesheet' href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <style>

        .font-color{
            color: white;
        }
        .nav-link:hover {
            color: black;
            background-color:whitesmoke;
            margin: 0;
            display: block;
        }
        .link:hover{
            color: tomato;
            text-decoration: none;
            margin: 0;
        }


    </style>

</head>
<body >
<header>
    <nav class="navbar navbar-expand-sm bg-dark fixed-top">
        <!-- Links -->
        <ul class="navbar-nav" >
            <li class="nav-item">
                <a class="nav-link font-color" href="/" style="padding-left:20px;"><i class="fas fa-home"></i> Home</a>
            </li>
        </ul>
    </nav>
    <br>
</header>
<div class="container">
    <br><br>

    <div class="row">
        <div class="col-sm-3"></div>
        <diV class="col-sm-6">
            <form:form modelAttribute="student">
                <form:hidden path="id"/>
                <div class="form-group">
                    <label>Name </label>
                    <form:input class="form-control" type="text" path="name" placeholder="Enter student name ..." autocomplete="false" required="true"/>
                </div>
                <div class="form-group">
                    <label>E-mail </label>
                    <form:input class="form-control" type="email" path="email" placeholder="Enter student email ..." autocomplete="false" required="true"/>
                    <label id="result" style="color: red"> </label>
                </div>
                <div class="form-group">
                    <label>Department </label>
                    <form:input class="form-control" type="text" path="dept" placeholder="Enter student department ..." autocomplete="false" required="true"/>
                </div>
                <div class="form-group">
                    <input class="form-control btn-success mt-2" type="submit" value="Submit"/>
                    <input class="form-control btn-primary mt-2" type="reset" value="Reset"/>
                </div>

            </form:form>

        </diV>
        <div class="col-sm-3"></div>

    </div>
    <br>
</div>

<script>

        $(document).ready(function () {
        $('#email').change(function () {
            var email = $('#email').val();

            $.ajax({
                type: 'GET',
                url: 'api/students/check/email?email='+email,
                success: function (result) {
                    if(result = true){
                        $('#result').html("E-mail already exist");
                    }
                }
            });
        });
    });

</script>
</body>
</html>
