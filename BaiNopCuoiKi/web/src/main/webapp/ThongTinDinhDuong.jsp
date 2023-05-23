<%--
  Created by IntelliJ IDEA.
  User: Bien
  Date: 5/23/2023
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông Tin Dinh Dưỡng</title>
    <link rel="stylesheet" href="styleNC.css">
</head>
<body>
<header>
    <h1>Phần mềm theo dõi dinh dưỡng</h1>
    <nav>
        <ul>
            <li><a href="#">Trang chủ</a></li>
            <li><a href="#">Thống kê</a></li>
            <li><a href="#">Cài đặt</a></li>
            <li><a href="#">Đăng xuất</a></li>
        </ul>
    </nav>
</header>
<main>
    <section>
        <h2 id="he">Thông tin dinh dưỡng</h2>
        <form >
            <table>
                <tr>
                    <td>Nhu cầu năng lượng cho chuyển hóa cơ bản BMR:
                        <br> <%=(Double) request.getAttribute("bmi")%> kcal/ngày.</td>
                </tr>
                <tr>
                    <td>Tổng nhu cầu cho tiêu hao hàng ngày TEE: <%=(Double) request.getAttribute("tee")%> kcal/ngày.</td>
                </tr>
                <tr>
                    <td> Nhu cầu cho tập luyện: E <%=(Double) request.getAttribute("e")%> kcal/ngày.</td>
                </tr>
                <tr>
                    <td> Nhu cầu đặc biệt(phụ nữ có thai): ES <%=(Integer) request.getAttribute("es")%> kcal/ngày.</td>
                </tr>
                <tr>
                    <td>Tổng nhu cầu năng lượng hàng ngày TE: <%=(Double) request.getAttribute("te")%> kcal/ngày.</td>
                </tr>
                <tr >
                    <td>Lượng tinh bột <%=(Double) request.getAttribute("amidon")%> kcal/ngày.</td>
                </tr>
                <tr>
                    <td>Lượng chất đạm <%=(Double) request.getAttribute("protein")%> kcal/ngày.</td>
                </tr>
                <tr>
                    <td>Lươợng chất béo <%=(Double) request.getAttribute("lipid")%> kcal/ngày.</td>
                </tr>


            </table>
            <button type="button" onclick="getBack()">Quay lại</button>
        </form>
    </section>
</main>
<footer>
</footer>
<script>

    function getBack(){

        history.back();
    }

</script>
</body>

</html>
