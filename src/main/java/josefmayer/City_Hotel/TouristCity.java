package josefmayer.City_Hotel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Josef Mayer on 30.05.2017.
 */


@Entity
@Table(name = "tourist_city")
public class TouristCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String country;

    @OneToMany (mappedBy = "touristCity")
    private Set<Hotel> hotels = new HashSet<>();

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public TouristCity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public TouristCity setCountry(String country) {
        this.country = country;
        return this;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

}
