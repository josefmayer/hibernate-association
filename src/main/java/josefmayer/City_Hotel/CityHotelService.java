package josefmayer.City_Hotel;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Josef Mayer on 30.05.2017.
 */
public class CityHotelService {

    Dao dao;
    TouristCity city1, city2, city3, city4,city5, city6;

    public void cityHotelAppMain(){
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example-mysql");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example-mssqlserver");

        dao = new Dao(emf);

        insertTouristCity();
        insertHotel();

        printAllTouristCities();
        printAllHotels();
        printHotelByName();

        printHotelsQueryJoin();

        emf.close();
    }

    public void insertTouristCity() {
        city1 = new TouristCity();
        city1.setName("Bordeaux").setCountry("France");
        dao.persistCity(city1);

        city2 = new TouristCity();
        city2.setName("Valencia").setCountry("Spain");
        dao.persistCity(city2);

        city3 = new TouristCity();
        city3.setName("Brighton").setCountry("United Kingdom");
        dao.persistCity(city3);

//        city4 = new TouristCity();
//        city4.setName("Bologna").setCountry("Italy");
//        dao.persistCity(city4);
//
//        city5 = new TouristCity();
//        city5.setName("Utrecht").setCountry("Netherlands");
//        dao.persistCity(city5);
//
//        city6 = new TouristCity();
//        city6.setName("Gent").setCountry("Belgium");
//        dao.persistCity(city6);
    }

    public void insertHotel() {

        Hotel hotel1 = new Hotel();
        hotel1.setCity(city1).setName("La Course").setStreet("Rue Laroche").setPostcode("1234");
        dao.persistHotel(hotel1);

        Hotel hotel2 = new Hotel();
        hotel2.setCity(city2).setName("Hotel Balneario").setStreet("Av del Cid").setPostcode("7788");
        dao.persistHotel(hotel2);

        Hotel hotel3= new Hotel();
        hotel3.setCity(city3).setName("Britannia Study").setStreet("Manor Hill").setPostcode("654");
        dao.persistHotel(hotel3);

        Hotel hotel4 = new Hotel();
        hotel4.setCity(city1).setStreet("Viale Aldini").setName("Hotel del Borgo").setPostcode("8642");
        dao.persistHotel(hotel4);

        Hotel hotel5 = new Hotel();
        hotel5.setCity(city1).setName("Van der Valk").setStreet("Ringwade").setPostcode("3355");
        dao.persistHotel(hotel5);

        Hotel hotel6 = new Hotel();
        hotel6.setCity(city2).setName("Gravensteen").setStreet("Damstraat").setPostcode("3344");
        dao.persistHotel(hotel6);

    }

    public void printAllTouristCities(){
        List<TouristCity> cityList = dao.findAllTouristCities();
        System.out.println("***** TouristCities *******");
        for (TouristCity city : cityList){
            System.out.println(city.getName() + " " + city.getCountry());
        }
    }

    public void printAllHotels(){
        List<Hotel> hotelList = dao.findAllHotels();
        System.out.println("***** Hotels *******");
        for (Hotel hotel : hotelList){
            System.out.println(hotel.getName());
        }
    }

    public void printHotelByName(){
        List<Hotel> hotelList = dao.findHotelByName("La Course");
        System.out.println("***** Hotel *******");
        for (Hotel hotel : hotelList){
            System.out.println(hotel.getName() + " " + hotel.getStreet());
        }
    }

    public void printHotelsQueryJoin(){
        List<Hotel> hotelList = dao.queryJoin();
        System.out.println("***** Hotels *******");
        for (Hotel hotel : hotelList){
            System.out.println(hotel.getName());
        }
    }


}