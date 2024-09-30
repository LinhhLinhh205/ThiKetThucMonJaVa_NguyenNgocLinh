package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;

/**
 *
 * Họ tên sinh viên: Nguyễn Ngọc Linh
 */
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

   
    public void DocKhachHang(String filename) {
        ArrayList<String> data = FileHelper.readFileText(filename); //doc file
        //đổ dữ liệu vào danh sách
        dsKhachHang.clear();
        for (String item : data) {
            String[] arr = item.split(";");
            KhachHang kh = new KhachHang();
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setSonhankhau(Integer.parseInt(arr[2]));
            kh.setChisocu(Double.parseDouble(arr[3]));
            kh.setChisomoi(Double.parseDouble(arr[4]));
            
            
            dsKhachHang.add(kh);
        }
      
    }

    public boolean GhiHoaDon(String filename) {
        
        ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso() + ";" + kh.getHoten() + ";"+kh.getTieuThu()+";"+kh.tinhTienTra();
            data.add(info);
        }
        return FileHelper.writeFileText(filename, data);
    }

   
    public void sapXepTheoMucTieuThu() {
          Comparator<KhachHang> cmp = (sv1, sv2) -> {
            return Double.compare(sv2.getTieuThu(), sv1.getTieuThu());
        };
        Collections.sort(dsKhachHang, cmp);        
    }
    
    public double getTieuThuCaoNhat()
    {
      double tieuthucaonhat = dsKhachHang.get(0).getTieuThu();
        for (KhachHang khachHang : dsKhachHang) {
            double tieuthu = khachHang.getTieuThu();
            if(tieuthucaonhat < tieuthu){
                tieuthucaonhat = tieuthu;
            }
        }
        return tieuthucaonhat;
    }
    
    public double getTieuThuThapNhat()
    {
       double min=0;
       return min;       
    }
    
    public double getTieuThuTrungBinh()
    {
        double avg;
        double tongtieuthu=0;
        int soluongkh=dsKhachHang.size();
        for(int i=0;i<dsKhachHang.size();i++){
            tongtieuthu+=dsKhachHang.get(i).getTieuThu();
        }
        avg=tongtieuthu/soluongkh;
        
       return Double.parseDouble(String.format("%.2f",avg));   
    }
}
