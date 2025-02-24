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

<form:form action="/ma-giam-gia/update" method="post" modelAttribute="mgg">

    ID:<form:input path="id" class="form-control"/>
    <form:errors path="id"/><br>

    Mã:<form:input path="maGiamGia" class="form-control"/>
    <form:errors path="maGiamGia" cssStyle="color: red"/><br>

    Tên:<form:input path="tenMaGiamGia" class="form-control"/>
    <form:errors path="tenMaGiamGia" class="text-danger"/><br>

    Giá trị giảm:<form:input path="giaTriGiam" class="form-control"/>
    <form:errors path="giaTriGiam" class="text-danger"/><br>

    Ngày bắt đầu:<form:input path="ngayBatDau" class="form-control"/>
    <form:errors path="ngayBatDau" class="text-danger"/><br>

    Ngày kết thúc:<form:input path="ngayKetThuc" class="form-control"/>
    <form:errors path="ngayKetThuc" class="text-danger"/><br>

    Mô tả:<form:input path="moTa" class="form-control"/>
    <form:errors path="moTa" class="text-danger"/><br>

    Số lượng:<form:input path="soLuong" class="form-control"/>
    <form:errors path="soLuong" class="text-danger"/><br>

    Điều kiện:<form:radiobutton path="dieuKien" value="0" checked="true"/>Đủ điều kiện
    <form:radiobutton path="dieuKien" value="1"/>Chưa đủ điều kiện<br><br>

    Trạng thái:<form:radiobutton path="trangThai" value="0" checked="true"/>Còn hạn
    <form:radiobutton path="trangThai" value="1"/>Hết hạn<br><br>

    <%--    Mã chức vụ:<form:select path="chucVu">--%>
    <%--    <form:options items="${listChucVu}" itemLabel="maChucVu" />--%>
    <%--</form:select><br><br>--%>

    <form:button type="submit" class="btn btn-outline-info">Update</form:button>
</form:form>
</body>
</html>
