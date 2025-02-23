<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Thương Hiệu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
<h2 class="text-center mb-4">Quản lý </h2>

<!-- Form nhập dữ liệu -->
<div class="card shadow-sm mb-4">
    <div class="card-header bg-primary text-white">Thêm </div>
    <div class="card-body">
        <form action="/mau-sac/add" method="post">
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <input type="text" class="form-control" name="ma" value="${detail.ma}" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <input type="text" class="form-control" name="ten" value="${detail.ten}" required>
            </div>

            <button type="submit" class="btn btn-success w-100">Thêm</button>
        </form>
    </div>
</div>

<!-- Bảng danh sách -->
<div class="card shadow-sm">
    <div class="card-header bg-dark text-white">Danh sách </div>
    <div class="card-body">
        <table class="table table-striped table-hover">
            <thead class="table-dark">
            <tr>
                <th>Mã</th>
                <th>Tên</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listt}" var="p">
                <tr>
                    <td>${p.ma}</td>
                    <td>${p.ten}</td>
                    <td>
                        <div class="btn-group">
                            <a href="/mau-sac/detail/${p.id}" class="btn btn-info btn-sm">Chi tiết</a>
                            <a href="/mau-sac/view-update/${p.id}" class="btn btn-warning btn-sm">Cập nhật</a>
                            <a href="/mau-sac/remove/${p.id}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
