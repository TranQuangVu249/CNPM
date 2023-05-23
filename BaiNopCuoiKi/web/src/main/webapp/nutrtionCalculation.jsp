<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Phần mềm theo dõi dinh dưỡng</title>
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
        <h2 id="he">Điền thông tin của bạn ngày hôm nay</h2>
        <form action="nutritionController" method="POST">
            <table>
                <tr>
                    <td>Cân nặng</td>
                    <td>
                        <input type="text" name="txtCannang" placeholder="kg" required>
                    </td>
                </tr>
                <tr>
                    <td>Chiều cao</td>
                    <td>
                        <input type="text" name="txtChieucao" placeholder="cm" required>
                    </td>
                </tr>
                <tr>
                    <td>Tuổi</td>
                    <td>
                        <input type="text" name="txtTuoi" required>
                    </td>
                </tr>
                <tr>
                    <td>Giới tính</td>
                    <td>
                        <select id="gender" name="gender">
                            <option value="male">Nam</option>
                            <option value="female">Nu</option>
                        </select>
                    </td>
                </tr>
                <tr id="pregnancy" style="display:none;">
                    <td>Bạn có đang mang thai không?</td>
                    <td>
                        <select id="pregnancyStatus" name="pregnancyStatus">
                            <option value="no">No</option>
                            <option value="yes">Yes</option>
                        </select>
                    </td>
                </tr>
                <tr id="pregnancyWeek" style="display:none;">
                    <td>Tuổi thai</td>
                    <td>
                        <select id="pregnancyStatusWeek" name="pregnancyStatusWeek">
                            <option value="12week">12 week</option>
                            <option value="24week">12 to 24 week</option>
                            <option value="36weel">remaining</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Nhu cầu tập luyện</td>
                    <td>
                        <select id="practice" name="practice">
                            <option value="no">No</option>
                            <option value="Low">Low</option>
                            <option value="Normal">Normal</option>
                            <option value="High">High</option>
                        </select>
                    </td>
                </tr>
                <tr id="timePractice" style="display:none;">
                    <td>Thoi gian tập luyện trong ngày</td>
                    <td>
                        <input type="text" name="txtTime" placeholder="giờ" required>
                    </td>
                </tr>
                <tr>
                    <td>Nhu cầu hoạt động trong ngày
                        (Low, Normal, High)
                    </td>
                    <td>
                        <input type="text" name="txtNhucau" required>
                    </td>
                </tr>

            </table>
            <button type="submit">Tính toán</button>
        </form>


    </section>
</main>
<footer>
</footer>
<script type="text/javascript">
    var practiceSelect = document.getElementById("practice");
    var timePractice = document.getElementById("timePractice");

    practiceSelect.addEventListener("change", function () {
        if (practiceSelect.value == "Low" || practiceSelect.value == "Normal" || practiceSelect.value == "High") {
            timePractice.style.display = "table-row";
        } else {
            timePractice.style.display = "none";
        }
    });
</script>
<script type="text/javascript">
    var genderSelect = document.getElementById("gender");
    var pregnancyDiv = document.getElementById("pregnancy");

    genderSelect.addEventListener("change", function () {
        if (genderSelect.value == "female") {
            pregnancyDiv.style.display = "table-row";
        } else {
            pregnancyDiv.style.display = "none";
        }
    });
</script>
<script type="text/javascript">
    var pregnancyStatus = document.getElementById("pregnancyStatus");
    var pregnancyForm = document.getElementById("pregnancyWeek");

    pregnancyStatus.addEventListener("change", function () {
        if (pregnancyStatus.value == "yes") {
            pregnancyForm.style.display = "block";
        } else {
            pregnancyForm.style.display = "none";
        }
    });
</script>
</body>
</html>