
package wizut.tpsi.ogloszenia.services;

import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import wizut.tpsi.ogloszenia.jpa.BodyStyle;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;
import wizut.tpsi.ogloszenia.jpa.FuelType;
import wizut.tpsi.ogloszenia.jpa.Offer;
import wizut.tpsi.ogloszenia.jpa.OfferFilter;


@Service
@Transactional
public class OffersService {

    @PersistenceContext
    private EntityManager em;

        
    public CarManufacturer getCarManufacturer(int id) {
        return em.find(CarManufacturer.class, id);
    }
    
    public CarModel getModel(int id) {
        return em.find(CarModel.class, id);
    }

    public List<CarManufacturer> getCarManufacturers() {
    String jpql = "select cm from CarManufacturer cm order by cm.name";
    TypedQuery<CarManufacturer> query = em.createQuery(jpql, CarManufacturer.class);
    List<CarManufacturer> result = query.getResultList();
    return result;
    
    
    //return em.createQuery("select cm from CarManufacturer cm order by cm.name", CarManufacturer.class).getResultList();
}
    
    public List<BodyStyle> getBodyStyles() {
    String jpql = "select cm from BodyStyle cm order by cm.name";
    TypedQuery<BodyStyle> query = em.createQuery(jpql, BodyStyle.class);
    List<BodyStyle> result = query.getResultList();
    return result;
    
   
}
    
    public List<FuelType> getFuelTypes() {
    String jpql = "select cm from FuelType cm order by cm.name";
    TypedQuery<FuelType> query = em.createQuery(jpql, FuelType.class);
    List<FuelType> result = query.getResultList();
    return result;
    
}
    
    
    public List<CarModel> getCarModels() {
        String jpql = "select cm from CarModel cm order by cm.manufacturer.name";

        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
 
        return query.getResultList();
}
    
    
    public List<Offer> getOffers(){
        
        String jpql = "select e from Offer e";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        return query.getResultList();
    }
    
    public List<Offer> getOffersByModel(int modelId){
    
        String jpql = "select cm from Offer cm where cm.model.id = :id order by cm.title";

        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", modelId);

        return query.getResultList();
         
    }
    
    public List<Offer> getOffersByManufacturer(int manufacturerId){
    
        String jpql = "select cm from Offer cm where cm.model.manufacturer.id = :id order by cm.title";

        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", manufacturerId);

        return query.getResultList();
         
    }
    
    
    public List<CarModel> getCarModelsByManufacturer(int manufacturerId){
        String jpql = "select cm from CarModel cm where cm.manufacturer.id = :id order by cm.name";

        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
        query.setParameter("id", manufacturerId);
        return query.getResultList();
    }
    
    
    public Offer getOffer(int id) {
        return em.find(Offer.class, id);
    }
    
    


    public Offer createOffer(Offer offer) {
    em.persist(offer);
    return offer;
    }
    
    public List<Offer> getOffers (OfferFilter filter){
        String jpql = "select cm from Offer cm where 1=1" +
                (filter.getModelId() != null && filter.getModelId() !=-1 ? " and  cm.model.id = :modelId" : "" )+
                (filter.getManufacturerId() != null && filter.getManufacturerId() != -1 ? " and  cm.model.manufacturer.id = :manufacturerId" : "") +
                (filter.getYearTo() != null ? " and  cm.year <= :yearTo" : "" )+
                (filter.getYearFrom() != null ? " and  cm.year >= :yearFrom" : "") +
                (filter.getFuelTypeId() != null && filter.getFuelTypeId() != -1 ? " and  cm.fuelType.id = :fuelTypeId" : "") +
                " order by cm.title";
        
        
        
//        String jpql = "select cm from Offer cm where cm.year >= :yearFrom and "
//                + "cm.year <= :yearTo and cm.fuelType.id = :fuelTypeId "
//                + " and cm.model.id = :modelId "
//                + "and cm.model.manufacturer.id = :manufacturerId order by cm.title";

        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        
        if(filter.getModelId() !=null && filter.getModelId() !=-1)
            query.setParameter("modelId", filter.getModelId());
        if(filter.getManufacturerId() !=null && filter.getManufacturerId() != -1)
            query.setParameter("manufacturerId", filter.getManufacturerId());
        if(filter.getYearTo() !=null)
            query.setParameter("yearTo", filter.getYearTo());
        if(filter.getYearFrom() !=null)
            query.setParameter("yearFrom", filter.getYearFrom());
        if(filter.getFuelTypeId() !=null && filter.getFuelTypeId() != -1)
            query.setParameter("fuelTypeId", filter.getFuelTypeId());
        
        return query.getResultList();
    }
    
    public Offer deleteOffer(Integer id) {
        Offer offer = em.find(Offer.class, id);
        em.remove(offer);
        return offer;
    }
    
    public Offer saveOffer(Offer offer) {
        return em.merge(offer);
    }
   
}
