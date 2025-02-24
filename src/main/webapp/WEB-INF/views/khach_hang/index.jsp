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

<%--<jsp:include page="/WEB-INF/view/header/sidebar.jsp"/>--%>

<div class="container">
    <h1 class="text-center">Khách hàng</h1>
<%--    <form action="/khach-hang/search" method="get">--%>
<%--        Mã:<input type="text" name="ma"/>--%>
<%--        <button type="submit">Search</button>--%>
<%--    </form>--%>

    <div class="mb-3">
        <form:form action="/khach-hang/add" method="post" modelAttribute="kh">
            ID:<form:input path="id" class="form-control"/>
            <form:errors path="id"/><br>

            Mã:<form:input path="maKhachHang" class="form-control"/>
            <form:errors path="maKhachHang" cssStyle="color: red"/><br>

            Tên:<form:input path="tenKhachHang" class="form-control"/>
            <form:errors path="tenKhachHang" class="text-danger"/><br>

            Giới tính:<form:radiobutton path="gioiTinh" value="0" checked="true"/>Nam
            <form:radiobutton path="gioiTinh" value="1"/>Nữ<br><br>

            Ngày sinh:<form:input path="ngaySinh" class="form-control"/>
            <form:errors path="ngaySinh" class="text-danger"/><br>

            SDT:<form:input path="soDienThoai" class="form-control"/>
            <form:errors path="soDienThoai" class="text-danger"/><br>

            Email:<form:input path="email" class="form-control"/>
            <form:errors path="email" class="text-danger"/><br>

            Trạng thái:<form:radiobutton path="trangThai" value="0" checked="true"/>Đang hoạt động
            <form:radiobutton path="trangThai" value="1"/>Ngừng hoạt động<br><br>

            Mật khẩu:<form:input path="matKhau" class="form-control"/>
            <form:errors path="matKhau" class="text-danger"/><br>

<%--            Mã chức vụ:<form:select path="chucVu">--%>
<%--            <form:options items="${listChucVu}" itemLabel="maChucVu" />--%>
<%--        </form:select><br><br>--%>


            <form:button type="submit" class="btn btn-outline-info">Add</form:button>
        </form:form>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>Mã khách hàng</th>
            <th>Tên khách hàng</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>SDT</th>
            <th>Email</th>
            <th>Trạng thái</th>
            <th>Mật khẩu</th>
<%--            <th>Mã chức vụ</th>--%>

            <th colspan="2">Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="kh" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${kh.id}</td>
                <td>${kh.maKhachHang}</td>
                <td>${kh.tenKhachHang}</td>
                <td>${kh.gioiTinh==0?"Nam":"Nữ"}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.soDienThoai}</td>
                <td>${kh.email}</td>
                <td>${kh.trangThai==0?"Đang hoạt động":"Ngừng hoạt động"}</td>
                <td>${kh.matKhau}</td>
<%--                <td>${kh.chucVu.maChucVu}</td>--%>
                <td>
                    <button class="btn btn-outline-warning"><a href="${pageContext.request.contextPath}/khach-hang/view-update?id=${kh.id}">Update</a></button>
<%--                    <button class="btn btn-outline-danger"><a href="${pageContext.request.contextPath}/khach-hang/remove?id=${kh.id}">Remove</a></button>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <p>Page : ${currentPage} / ${totalPages}</p>
        <button class="btn btn-outline-info"><a href="${pageContext.request.contextPath}/khach-hang/hien-thi?page=${currentPage <= 1 ? 1 : (currentPage - 1) }">Previous</a></button>
        <button class="btn btn-outline-info"><a href="${pageContext.request.contextPath}/khach-hang/hien-thi?page=${currentPage >= totalPages ? currentPage : (currentPage + 1) }">Next</a></button>
    </div>
</div>
</body>
</html>
