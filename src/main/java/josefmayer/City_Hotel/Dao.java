package josefmayer.City_Hotel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Josef Mayer on 30.05.2017.
 */
public class Dao {

    public Dao(EntityManagerFactory emf){
        this.emf = emf;
    }

    private EntityManagerFactory emf;

    public void persistCity(TouristCity city) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        em.close();
    }

    public void persistHotel(Hotel hotel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(hotel);
        em.getTransaction().commit();
        em.close();
    }

    //JPQL
    public List<TouristCity> findAllTouristCities(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT city FROM TouristCity city");
        List<TouristCity> resultList = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    //JPQL
    public List<Hotel> findAllHotels(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT hotel FROM Hotel hotel");
        List<Hotel> resultList = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return resultList;
    }


    //JPQL
    public List<Hotel> findHotelByName(String hotel){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery(
                "SELECT hotel FROM Hotel hotel WHERE hotel.name = :hotelName"
        ).setParameter("hotelName", hotel);

        List<Hotel> resultList = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return resultList;
    }

    public List<Hotel> queryJoin(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("select h from TouristCity tc inner join tc.hotels h ");
        List<Hotel> resultList = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return resultList;
    }




}
