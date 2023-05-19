package org.example.service;

public class nutritionCalculationService {
    public double tinhChiSoBMI(double canNang, double chieuCao) {
        double chiSoBMI = canNang / Math.pow(chieuCao / 100, 2);
        return chiSoBMI;
    }

}
