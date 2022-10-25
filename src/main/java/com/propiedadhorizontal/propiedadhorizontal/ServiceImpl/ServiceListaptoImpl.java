package com.propiedadhorizontal.propiedadhorizontal.ServiceImpl;

import com.propiedadhorizontal.propiedadhorizontal.DAO.ListaptoDao;
import com.propiedadhorizontal.propiedadhorizontal.Modelo.Listapto;
import com.propiedadhorizontal.propiedadhorizontal.Service.ServiceListapto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceListaptoImpl implements ServiceListapto{
    
    @Autowired
    private ListaptoDao getDao;
    
    @Override
    public List<Listapto> getListaListapto() {
        return getDao.findAll();
    }
    @Override
    public Listapto crearListapto(Listapto listapto) {
        if(listapto != null){
            return getDao.save(listapto);
        }
        return null;
    }
    @Override
    public Listapto ActualizarStockListapto(Listapto listapto) {
        if(listapto != null && listapto.getIdpk() != 0){
            Listapto listaptoBD = getDao.getReferenceById(listapto.getIdpk());
            if(listaptoBD != null){
                listaptoBD.setList(listapto.getList()==0?listaptoBD.getList()
                        :listaptoBD.getList()+listaptoBD.getList());
                return getDao.save(listaptoBD);
            } 
        }
        return null;
    }
    @Override
    public Boolean EliminarListapto(Long id) {
          if(id != null && id != 0){
            Listapto listaptoBD = getDao.getReferenceById(id);
            if(listaptoBD != null){
                getDao.deleteById(id);
                 return true;
            }
          }
           return false;
    }
}
