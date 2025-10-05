<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sach dien thoai</title>
    <style>
        table, th, td { border: 1px solid gray; border-collapse: collapse; padding: 5px; }
    </style>
</head>
<body>
<h2>Danh sach dien thoai</h2>

<form method="get" action="danhsach">
    <select name="mancc">
        <option value="">-- Chon nha cung cap --</option>
        <c:forEach var="ncc" items="${dsNCC}">
            <option value="${ncc.maNCC}">${ncc.tenNhaCC}</option>
        </c:forEach>
    </select>
    <button type="submit">Loc</button>
</form>

<table>
    <tr>
        <th>Ma DT</th><th>Ten DT</th><th>Nam SX</th><th>Cau hinh</th><th>Hinh anh</th><th>Nha CC</th><th>Hanh dong</th>
    </tr>
    <c:forEach var="dt" items="${dsDT}">
        <tr>
            <td>${dt.maDT}</td>
            <td>${dt.tenDT}</td>
            <td>${dt.namSanXuat}</td>
            <td>${dt.cauHinh}</td>
            <td><img src="assets/images/${dt.hinhAnh}" width="80"/></td>
            <td>${dt.nhaCungCap.tenNhaCC}</td>
            <td><a href="xoa?maDT=${dt.maDT}" onclick="return confirm('Xoa dien thoai nay')"> Xoa</a></td>
        </tr>
    </c:forEach>
</table>

<a href="them"> Them dien thoai moi</a>
</body>
</html>
