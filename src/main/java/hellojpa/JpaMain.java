package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Team;
import hellojpa.domain.cascade.Child;
import hellojpa.domain.cascade.Parent;
import hellojpa.domain.embeded.Address;
import hellojpa.domain.embeded.Period;
import hellojpa.domain.item.Item;
import hellojpa.domain.item.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        try{
            Address address = new Address("city", "street", "zipcode");

            Member member1 = new Member();
            member1.setName("member1");
            member1.setHomeAddress(address);
            em.persist(member1);

            Address copyAddress = new Address("newCity", address.getStreet(), address.getZipcode());

            Member member2 = new Member();
            member2.setName("member1");
            member2.setHomeAddress(copyAddress);
            em.persist(member2);

            member1.getHomeAddress().setCity("new City");

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

}
