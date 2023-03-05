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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        try{
            //String sql ="select concat('a','b') from Member m";
//            String sql ="select 'a'||'b' from Member m";

            //String sql ="select substring(m.username,2,3) from Member m";
//            String sql ="select locate('de','abcdefg') from Member m"; // de가 시작하는 숫자

//            String sql="select size(t.members) from Team t";


            String sql ="select function('group_concat',m.username) from Member m";

            em.createQuery(sql,Member.class).getResultList();

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
    /*public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        try{
            String username=""  ;

            String sql = "select m from Member m";

            if(username!=null && username!=""){
                sql+=" where m.name="+username;
            }

            List<Member> members = em.createQuery
                    (sql, Member.class).getResultList();

            for (Member member : members) {
                System.out.println("member.getName() = " + member.getName());
            }

*//*            //Criteria 사용 준비
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//루트 클래스 (조회를 시작할 클래스)
            Root<Member> m = query.from(Member.class);
//쿼리 생성
            CriteriaQuery<Member> cq = query.select(m);
            String name="asd";
            if(name!=null){
                cq.where(cb.equal(m.get("username"), "kim"));
            }
            List<Member> resultList = em.createQuery(cq).getResultList();*//*


            em.createNativeQuery("select * from member where name='kim'",Member.class).getResultList();


            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }*/

}
