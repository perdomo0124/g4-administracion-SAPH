package com.propiedadhorizontal.propiedadhorizontal.ServiceImpl;

import com.propiedadhorizontal.propiedadhorizontal.DAO.AptoDao;
import com.propiedadhorizontal.propiedadhorizontal.Modelo.Apto;
import com.propiedadhorizontal.propiedadhorizontal.Service.ServiceApto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceAptoImpl implements ServiceApto{
    
    @Autowired
    private AptoDao getDao;

    @Override
    public List<Apto> getListaApto() {
        return getDao.findAll();
    }
    @Override
    public Apto crearApto(Apto apto) {
        if (apto != null) {
            return getDao.save(apto);
        }
        return null;
    }
    @Override
    public Apto ActualizarApto(Apto apto) {
        if (apto != null && apto.getIdpk() != 0) {
            Apto aptoBD = getDao.getReferenceById(apto.getIdpk());
            if (aptoBD != null) {
                aptoBD.setCuota(apto.getCuota());
                aptoBD.setDescripcion(apto.getDescripcion());
                return getDao.save(aptoBD);
            }
        }
        return null;
    }

    @Override
    public Boolean EliminarApto(Long id) {
        if (id != null && id != 0) {
            Apto aptoBD = getDao.getReferenceById(id);
            if (aptoBD != null) {
                getDao.deleteById(id);
                return true;
            }
        }
        return false;
    }

    
}
