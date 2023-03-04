package hellojpa;

import hellojpa.domain.Member;
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
            Member member = new Member();
            member.setName("user1");
            member.setCreateBy("kim");
            member.setCreateDate(LocalDateTime.now());



/*
            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("바람과 함께 사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = " + findMovie);

            Item item = em.find(Item.class, movie.getId());
            System.out.println("item = " +item);
*/



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

    public static void test1(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx=null;
        try{
            tx = em.getTransaction();
            tx.begin();

            //전체조회
            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

            // 페이징
            List<Member> pageMembers = em.createQuery("select m from Member m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(5)
                    .getResultList();

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    public static void test2(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx=null;
        try{
            tx = em.getTransaction();
            tx.begin();

            Member member = new Member();
            member.setName("HelloJPA");

            System.out.println("===Before===");
            em.persist(member);
            System.out.println("===after===");

            Member findMember = em.find(Member.class, member.getId());



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    public static void test3(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx=null;
        try{
            tx = em.getTransaction();
            tx.begin();

            Member findMember1 = em.find(Member.class, 1L);
            Member findMember2 = em.find(Member.class, 1L);

            System.out.println("findMember1==findMember2 ? "+(findMember1==findMember2));

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }


    public static void test4(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx=null;
        try{
            tx = em.getTransaction();
            tx.begin();

            Member member1 = new Member();
            member1.setName("memberA");

            Member member2 = new Member();
            member2.setName("memberB");

            em.persist(member1);
            em.persist(member2);

            Member findMember = em.find(Member.class, member1.getId());
            findMember.setName("memberChange");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
