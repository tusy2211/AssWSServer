/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Lichsugd;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import util.NewHibernateUtil;

/**
 *
 * @author khanh
 */
public class SearchTime {

    public List<Lichsugd> transfer(Date start, Date end, String tkGui, String pass) {
        try {
            Session session = NewHibernateUtil.getSessionAndBeginTransaction();
            LichSuDAO dao = new LichSuDAO();
            return dao.search(start, end, tkGui, pass, session);
        } catch (Exception e) {
            e.printStackTrace();
            NewHibernateUtil.rollBackCurrentSessions();
        } finally {
            try {
                NewHibernateUtil.commitCurrentSessions();
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    NewHibernateUtil.closeCurrentSessions();
                } catch (Exception ex) {
                    Logger.getLogger(LichSuDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}
