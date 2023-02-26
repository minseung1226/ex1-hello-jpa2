package hellojpa;

import hellojpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx=null;
        try{
            tx = em.getTransaction();
            tx.begin();

            //저장
            Member member = new Member();
            member.setName("member1");
            em.persist(member);

            //수정
            Member findMember = em.find(Member.class, member.getId());

            //삭제
            findMember.setName("member2");
            em.remove(findMember);

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
}
