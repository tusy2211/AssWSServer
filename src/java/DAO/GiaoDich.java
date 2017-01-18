/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Customer;
import entity.Lichsugd;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.hibernate.Session;
import util.NewHibernateUtil;

/**
 *
 * @author khanh
 */
public class GiaoDich {

    public Double fee(Double sotien) {
        Double fee = 10000.0;
        if (sotien <= 100000.0) {
            return fee;
        } else if (sotien > 100000.0 && sotien <= 500000.0) {
            fee = sotien * 0.02;
            return fee;
        } else if (sotien > 500000.0 && sotien <= 1000000.0) {
            fee = sotien * 0.015;
            return fee;
        } else if (sotien > 1000000.0 && sotien <= 5000000.0) {
            fee = sotien * 0.01;
            return fee;
        } else {
            fee = sotien * 0.005;
            return fee;
        }
    }

    public boolean containNumbersOnly(String source) {
        boolean result = false;
        Pattern pattern = Pattern.compile("[1-9]+.[0-9]+"); //correct pattern for both float and integer.
        //pattern = Pattern.compile("\\d+.\\d+"); //correct pattern for both float and integer.

        result = pattern.matcher(source).matches();
        if (result) {
            return true;
        } else {
            return false;
        }
    }

    public boolean giaoDich(String maKh_gui, String maKh_nhan, String pwd, Double soTien, String choice) throws NullPointerException, Exception {
        try {
            Session session = NewHibernateUtil.getSessionAndBeginTransaction();
            Lichsugd ls = new Lichsugd();
            LichSuDAO dao = new LichSuDAO();

            Customer c1 = dao.getCustomerById(maKh_gui, session);
            Customer c2 = dao.getCustomerById(maKh_nhan, session);
            if (c1 == null || c2 == null || ls == null) {
                throw new Exception("Wrong");
            }
            ls.setNguoigui(maKh_gui);
            ls.setNguoinhan(maKh_nhan);
            ls.setThoigiangiaodich(Date.from(Instant.now()));
            if (soTien != null) {
                if (soTien <= c1.getSodu()) {
                    Double phi = fee(soTien);
                    ls.setSotiengiaodich(soTien);
                    ls.setPhigiaodich(phi);
                    if ("DT".equals(choice)) {
                        c1.setSodu(c1.getSodu() - soTien - phi);
                        c2.setSodu(c2.getSodu() + soTien);
                    } else if ("KH".equals(choice)) {
                        c1.setSodu(c1.getSodu() - soTien);
                        c2.setSodu(c2.getSodu() + soTien - phi);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }

            List<Lichsugd> lichSu = dao.getAll(session);
            int count = 1;
            for (Lichsugd t : lichSu) {
                if (dao.validateGd(t.getNguoigui(), t.getNguoinhan(), session) != null) {
                    if (dao.validateGd(t.getNguoigui(), t.getNguoinhan(), session).equals(dao.validateGd(maKh_gui, maKh_nhan, session))) {
                        count++;
                    }
                }
            }
            ls.setSogd(count);

            if (dao.validateAccount(maKh_gui, pwd, session) != null && dao.validateAccountID(maKh_nhan, session) != null && maKh_gui.equals(maKh_nhan) == false) {
                dao.createLichSu(ls, session);
                dao.updateTKKhachHang(c1, session);
                dao.updateTKKhachHang(c2, session);
                NewHibernateUtil.commitCurrentSessions();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            NewHibernateUtil.rollBackCurrentSessions();
        } finally {
            try {
                NewHibernateUtil.closeCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
}
