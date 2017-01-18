/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAO.GiaoDich;
import DAO.SearchTime;
import entity.Lichsugd;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author khanh
 */
@WebService(serviceName = "TransferWebService")
public class TransferWebService {
    private GiaoDich dao = new GiaoDich();
    private SearchTime st = new SearchTime();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "giaodich")
    public boolean giaodich(@WebParam(name = "maKHgui") String maKHgui,@WebParam(name = "maKHnhan") String maKHnhan,@WebParam(name = "password") String password,@WebParam(name = "sotien") Double sotien,@WebParam(name = "choice") String choice) {
        try {
            return dao.giaoDich(maKHgui, maKHnhan, password, sotien, choice);
        } catch (Exception ex) {
            Logger.getLogger(TransferWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @WebMethod(operationName = "lichsu")
    public List<Lichsugd> lichsu(@WebParam(name = "start") Date start,@WebParam(name = "end") Date end,@WebParam(name = "khGui") String khGui,@WebParam(name = "password") String password) {
        return st.transfer(start, end, khGui, password);
    }
}
