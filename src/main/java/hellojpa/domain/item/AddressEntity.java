package hellojpa.domain.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AddressEntity {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    public AddressEntity(Long id, String city, String street, String zipcode) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
