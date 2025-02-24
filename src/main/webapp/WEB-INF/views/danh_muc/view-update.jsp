<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/danh-muc/update" method="post" modelAttribute="dm">

    ID:<form:input path="id" class="form-control"/>
    <form:errors path="id"/><br>

    Mã:<form:input path="maDanhMuc" class="form-control"/>
    <form:errors path="maDanhMuc" cssStyle="color: red"/><br>

    Tên:<form:input path="tenDanhMuc" class="form-control"/>
    <form:errors path="tenDanhMuc" class="text-danger"/><br>

    Trạng thái:<form:radiobutton path="trangThai" value="0" checked="true"/>Đang sử dụng
    <form:radiobutton path="trangThai" value="1"/>Ngừng sử dụng<br><br>

    <%--    Mã chức vụ:<form:select path="chucVu">--%>
    <%--    <form:options items="${listChucVu}" itemLabel="maChucVu" />--%>
    <%--</form:select><br><br>--%>

    <form:button type="submit" class="btn btn-outline-info">Update</form:button>
</form:form>
</body>
</html>
