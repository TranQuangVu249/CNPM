package main.service;

public class nutritionCalculationService {
    //BMR
    public double tinhChiSoBMRFemale(double canNang, double chieuCao, double tuoi, String nhuCau) {
        double chiSoBMR = 655 + (9.6 * canNang) + (1.8 * chieuCao) - (4.7 * tuoi);
        return chiSoBMR;
    }

    public double tinhChiSoBMRMale(double canNang, double chieuCao, double tuoi, String nhuCau) {
        double chiSoBMR = 66 + (13.7 * canNang) + (5 * chieuCao) - (6.8 * tuoi);
        return chiSoBMR;
    }

    //TEE
    public double tinhChiSoTEE(double chiSoBMR, String nhuCau) {
        double TEE;
        if (nhuCau.equals("Low"))
            TEE = chiSoBMR * 1.375;
        else {
            if (nhuCau.equals("Normal"))
                TEE = chiSoBMR * 1.55;
            TEE = chiSoBMR * 1.725;

        }
        return TEE;

    }

    //Nhu cầu tập luyện E
    public double tinhChiSoE(String tapLuyen, double timePr) {
        double E = 0;
        if (tapLuyen.equals("Low"))
            E = 200 * timePr;
        else {
            if (tapLuyen.equals("Normal")) {
                E = 300 * timePr;
            }
            E = 400 * timePr;

        }
        return E;
    }

    public double tinhChiSoTE(double TEE, double E, double ES) {
        double TE;
        TE = TEE + E + ES;
        return TE;
    }

    //tinh lượng tinh bột
    public double tinhAmidon(double TE) {
        double amidon = TE * 0.6;
        return amidon;
    }

    //tính lượng chất đạm
    public double tinhProtein(double TE) {
        double protein = TE * 0.15;
        return protein;
    }

    //tính lượng chất béo
    public double tinhLipid(double TE) {
        double lipid = TE * 0.25;
        return lipid;
    }
}
