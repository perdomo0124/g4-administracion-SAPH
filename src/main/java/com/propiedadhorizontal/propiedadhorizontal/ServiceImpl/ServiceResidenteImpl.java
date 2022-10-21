package com.propiedadhorizontal.propiedadhorizontal.ServiceImpl;

/**
 * @author Indira
 */
import com.propiedadhorizontal.propiedadhorizontal.DAO.ResidenteDao;
import com.propiedadhorizontal.propiedadhorizontal.Modelo.Residente;
import com.propiedadhorizontal.propiedadhorizontal.Service.ServiceResidente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceResidenteImpl implements ServiceResidente{
    
     @Autowired
    private ResidenteDao getDao;

    @Override
    public List<Residente> getListaResidente() {
        return getDao.findAll();
    }
    @Override
    public Residente crearResidente(Residente residente) {
        if (residente != null) {
            return getDao.save(residente);
        }
        return null;
    }
    @Override
    public Residente ActualizarResidente(Residente residente) {
        if (residente != null && residente.getIdpk() != 0) {
            Residente residenteBD = getDao.getReferenceById(residente.getIdpk());
            if (residenteBD != null) {
                residenteBD.setNombre(residente.getNombre());
               residenteBD.setDoc(residente.getDoc());
                residenteBD.setTelefono(residente.getTelefono());
                return getDao.save(residenteBD);
            }
        }
        return null;
    }
    @Override
    public Boolean EliminarResidente(Long id) {
 
        if(id != null && id != 0){
            Residente residenteBD = getDao.getReferenceById(id);
            if(residenteBD != null){
                getDao.deleteById(id);
                 return true;
            }
          }
           return false;
    }
}
