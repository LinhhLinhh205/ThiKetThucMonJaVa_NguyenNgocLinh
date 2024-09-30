package model;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * Họ tên sinh viên: Nguyễn Ngọc Linh
 */
public class KhachHang {
    private String maso;
    private String hoten;
    private int sonhankhau;
    private double chisocu;
    private double chisomoi;            

    //constructor
    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int sonhankhau, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.sonhankhau = sonhankhau;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    //setter và getter

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSonhankhau() {
        return sonhankhau;
    }

    public void setSonhankhau(int sonhankhau) {
        this.sonhankhau = sonhankhau;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }        
    
    //phương thức tính toán    

    public double getTieuThu()
    {
      return chisomoi-chisocu;
    }
    
    public double getDinhMuc()
    {
       return sonhankhau*4;
    }
    
    
    public String tinhTienTra()
    {
        
       double tieuThu=getTieuThu();
       double dinhMuc=getDinhMuc();
       double tienTra=0;
       NumberFormat formatter = NumberFormat.getInstance(Locale.US);
       if(tieuThu<=dinhMuc){
           tienTra=tieuThu*6700;
       }else if(tieuThu<=dinhMuc+2*sonhankhau){
           tienTra=dinhMuc*6700+(tieuThu-dinhMuc)*12900;
       }else{
           tienTra=dinhMuc*6700+2*sonhankhau*12900+(tieuThu-dinhMuc-2*sonhankhau)*14400;
       }
       double thueGTGT=0.05*tienTra;
       double TDVTN=0.25*tienTra;
       double thueTDVTN=0.08*TDVTN;
       double tongTien= tienTra+thueGTGT+TDVTN+thueTDVTN;
       return formatter.format(tongTien);
    }         
}
