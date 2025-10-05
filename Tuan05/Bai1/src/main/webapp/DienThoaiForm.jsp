<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Them dien thoai</title>
</head>
<body>
<h2>Them dien thoai moi</h2>

<form method="post" enctype="multipart/form-data" action="them">
    <p>Ma DT: <input name="maDT" required /></p>
    <p>Ten DT: <input name="tenDT" required /></p>
    <p>Nam SX: <input name="namSX" type="number" pattern="\\d{4}" required /></p>
    <p>Cau hinh: <input name="cauHinh" maxlength="255" required /></p>
    <p>Nha cung cap:
        <select name="maNCC">
            <c:forEach var="ncc" items="${dsNCC}">
                <option value="${ncc.maNCC}">${ncc.tenNhaCC}</option>
            </c:forEach>
        </select>
    </p>
    <p>Hinh anh: <input type="file" name="hinhAnh" accept=".jpg,.jpeg,.png" required /></p>
    <p><button type="submit">Thêm</button></p>
</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<a href="danhsach"> Quay lai danh sach</a>
</body>
</html>
