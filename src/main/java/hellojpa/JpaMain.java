package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Team;
import hellojpa.domain.cascade.Child;
import hellojpa.domain.cascade.Parent;
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

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(child1);
            em.persist(child2);
            em.persist(parent);



/*
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);



            Member member = new Member();
            member.setName("user1");
            member.setTeam(team);

            em.persist(member);

            Member member2 = new Member();
            member2.setName("user1");
            member2.setTeam(team2);


            em.persist(member2);

            em.flush();
            em.clear();

            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();

            for (Member member1 : members) {
                System.out.println("member1.getName() = " + member1.getName());

            }
*/


/*
            Member findMember = em.getReference(Member.class, member.getId());
            System.out.println("findMember.getClass() = " + findMember.getClass());

            System.out.println("isLoaded =" +emf.getPersistenceUnitUtil().isLoaded(findMember));
*/



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
