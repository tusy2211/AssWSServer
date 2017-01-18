/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Customer;
import entity.Lichsugd;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import util.NewHibernateUtil;

/**
 *
 * @author khanh
 */
public class LichSuDAO {

    public boolean createLichSu(Lichsugd lichsu,Session session) {
//        Session session = NewHibernateUtil.getSessionAndBeginTransaction();

        try {
            String hql = "INSERT INTO Lichsugd(nguoigui,nguoinhan,thoigiangiaodich,sotiengiaodich,phigiaodich,sogd) "
                    + " VALUES(:nguoigui,:nguoinhan,:thoigiangiaodich,:sotiengiaodich,:phigiaodich,:sogd)";;
            Query query = session.createSQLQuery(hql);
            query.setParameter("nguoigui", lichsu.getNguoigui());
            query.setParameter("nguoinhan", lichsu.getNguoinhan());
            query.setParameter("thoigiangiaodich", lichsu.getThoigiangiaodich());
            query.setParameter("sotiengiaodich", lichsu.getSotiengiaodich());
            query.setParameter("phigiaodich", lichsu.getPhigiaodich());
            query.setParameter("sogd", lichsu.getSogd());
            query.executeUpdate();

            return true;
        } catch (Exception e) {
        } finally {
            try {
//                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
//                NewHibernateUtil.rollBackCurrentSessions();
            } finally {
                try {
//                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean updateTKKhachHang(Customer customer,Session session) {
        try {
//            Session session = NewHibernateUtil.getSessionAndBeginTransaction();
            String hql = "UPDATE Customer SET sodu= :sodu WHERE makhachhang= :maKH";
            Query query = session.createQuery(hql);
            query.setParameter("sodu", customer.getSodu());
            query.setParameter("maKH", customer.getMakhachhang());

            query.executeUpdate();
//            NewHibernateUtil.commitCurrentSessions();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
//                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
//                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public Customer getCustomerById(String customer,Session session) {
//        Session session = NewHibernateUtil.getSessionAndBeginTransaction();
        try {

            String hql = "SELECT t FROM Customer t WHERE t.makhachhang = :makhachhang";
            Query query = session.createQuery(hql);
            query.setParameter("makhachhang", customer);
            return (Customer) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            try {
//                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
//                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public Customer getCustomersById(String customer,String pwd,Session session) {
//        Session session = NewHibernateUtil.getSessionAndBeginTransaction();
        try {

            String hql = "SELECT t FROM Customer t WHERE t.makhachhang = :makhachhang AND t.matkhau = :matkhau";
            Query query = session.createQuery(hql);
            query.setParameter("makhachhang", customer);
            query.setParameter("matkhau", pwd);
            return (Customer) query.uniqueResult();
        } catch (Exception e) {
        } finally {
            try {
//                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
//                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public Customer validateAccount(String maKh, String pwd,Session session) {
//        Session session = NewHibernateUtil.getSessionAndBeginTransaction();
        try {

            String hql = "SELECT a FROM Customer a WHERE a.makhachhang = :maKH AND a.matkhau = :pwd";
            Query query = session.createQuery(hql);
            query.setParameter("maKH", maKh);
            query.setParameter("pwd", pwd);
            List<Customer> list = query.list();
            if (list.size() == 1) {
                return list.get(0);
            }
        } catch (Exception e) {
        } finally {
            try {
//                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
//                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public Customer validateAccountID(String maKh,Session session) {

//        Session session = NewHibernateUtil.getSessionAndBeginTransaction();
        try {

            String hql = "SELECT a FROM Customer a WHERE a.makhachhang = :maKH";
            Query query = session.createQuery(hql);
            query.setParameter("maKH", maKh);
            List<Customer> list = query.list();
            if (list.size() == 1) {
                return list.get(0);
            }
            return null;
        } catch (Exception e) {
        } finally {
            try {
//                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
//                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public Lichsugd validateGd(String maKh_gui, String maKh_nhan,Session session) {
//        Session session = NewHibernateUtil.getSessionAndBeginTransaction();
        try {

            String hql = "SELECT a FROM Lichsugd a WHERE a.nguoigui = :gui AND a.nguoinhan = :nhan";
            Query query = session.createQuery(hql);
            query.setParameter("gui", maKh_gui);
            query.setParameter("nhan", maKh_nhan);
            List<Lichsugd> list = query.list();
            if (list.size() >= 1) {
                return list.get(0);
            }
            return null;
        } catch (Exception e) {
        } finally {
            try {
//                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
//                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public List<Lichsugd> getAll(Session session) {
//        Session session = NewHibernateUtil.getSessionAndBeginTransaction();
        try {

            String hql = "SELECT t FROM Lichsugd t";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
        } finally {
            try {
//                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
//                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public List<Lichsugd> search(Date start, Date end, String tkGui, String password,Session session) {
//        Session session = NewHibernateUtil.getSessionAndBeginTransaction();
        try {
            String hql = "SELECT t FROM Lichsugd t WHERE t.thoigiangiaodich >= :batdau AND t.thoigiangiaodich <= :ketthuc AND (t.nguoigui = :gui OR t.nguoinhan = :nhan)";
            Query query = session.createQuery(hql);
            query.setParameter("batdau", start);
            query.setParameter("ketthuc", end);
            query.setParameter("gui", tkGui);
            query.setParameter("nhan", tkGui);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
//                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
//                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}
