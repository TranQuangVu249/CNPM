package main.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.service.nutritionCalculationService;

import java.io.IOException;

@WebServlet(name = "nutritionController", urlPatterns = "/nutritionController")
public class nutritionController extends HttpServlet {
    private nutritionCalculationService nutritionCalculationService;

    public void init() {
        nutritionCalculationService = new nutritionCalculationService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy dữ liệu từ form
        double canNang = Double.parseDouble(request.getParameter("txtCannang"));
        double chieuCao = Double.parseDouble(request.getParameter("txtChieucao"));
        double tuoi = Double.parseDouble(request.getParameter("txtTuoi"));
        String selectedGender = request.getParameter("gender");
        boolean isFemale = ("Nu".equals(selectedGender));
        String tapLuyen = request.getParameter("practice");
        String nhuCau = request.getParameter("txtNhucau");


        //Tinhs nhu cầu đặc biệt
        boolean isPregnant = false;
        int ES = 0;

        //có mang thai hay không
        String pregnant = request.getParameter("pregnancyStatus");
        if (pregnant != null) {
            isPregnant = ("Yes".equals(pregnant));
        }

        // số tuần tuổi thai
        String pregnantW = request.getParameter("pregnancyStatusWeek");
        int IntPregnantW = 0;
        if (pregnantW != null) {

            if ("12 week".equals(pregnant))
                IntPregnantW = 0;
            else {
                if ("12 to 24 week".equals(pregnant))
                    IntPregnantW = 360;
                IntPregnantW = 475;
            }

        }

        if (isPregnant) {
            ES += IntPregnantW;
        }


        
        //Tính nhu cầu tập luyện
        double E = 0;
        //Thời gian tập luyện
        double timePr = 0;
        if (tapLuyen.equals("Low") || tapLuyen.equals("Normal") || tapLuyen.equals("High")) {
            String timePratice = request.getParameter("txtTime");
            
            if (timePratice != null) {
                timePr = Double.parseDouble(timePratice.replace(",", "."));
            }
            E = nutritionCalculationService.tinhChiSoE(tapLuyen, timePr);
        }



        // Tính toán chi số BMR
        double chiSoBMR;
        if (isFemale) {
            chiSoBMR = nutritionCalculationService.tinhChiSoBMRFemale(canNang, chieuCao, tuoi, nhuCau);
        } else chiSoBMR = nutritionCalculationService.tinhChiSoBMRMale(canNang, chieuCao, tuoi, nhuCau);

        //Tính chỉ số TEE
        double TEE;
        TEE = nutritionCalculationService.tinhChiSoTEE(chiSoBMR, nhuCau);

        //Tính nhu cầu năng lượng cả ngày
        double TE;
        TE = nutritionCalculationService.tinhChiSoTE(TEE, E, ES);

        //Tính lượng tinh bột
        double amidon;
        amidon = nutritionCalculationService.tinhAmidon(TE);

        //Tính lượng chất béo
        double lipid;
        lipid = nutritionCalculationService.tinhAmidon(TE);

        //Tính lượng chất đạm
        double protein;
        protein = nutritionCalculationService.tinhAmidon(TE);

        // Hiển thị kết quả cho người dùng
//            response.getWriter().println("Chi số BMI của bạn là: " + chiSoBMI);
        request.setAttribute("bmi", chiSoBMR);
        request.setAttribute("tee", TEE);
        request.setAttribute("e", E);
        request.setAttribute("es",ES);
        request.setAttribute("te", TE);
        request.setAttribute("amidon", amidon);
        request.setAttribute("protein", protein);
        request.setAttribute("lipid", lipid);
        request.getRequestDispatcher("ThongTinDinhDuong.jsp").forward(request, response);

    }
}

