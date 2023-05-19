package org.example.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.service.nutritionCalculationService;

import java.io.IOException;

public class nutritionController {
        private nutritionCalculationService nutritionCalculationService

;

        public void init() {
            nutritionCalculationService = new nutritionCalculationService();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // Lấy dữ liệu từ form
            double canNang = Double.parseDouble(request.getParameter("txtCannang"));
            double chieuCao = Double.parseDouble(request.getParameter("txtChieucao"));

            // Tính toán chi số BMI
            double chiSoBMI = nutritionCalculationService.tinhChiSoBMI(canNang, chieuCao);

            // Hiển thị kết quả cho người dùng
            response.getWriter().println("Chi số BMI của bạn là: " + chiSoBMI);
        }
    }

