package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    // JPA를 사용하기 때문에 Entity 매니저가 있어야 함.
    // 스프링부트여서 결국 스프링 컨테이너 위에서 모든게 다 동작함
    @PersistenceContext // 주입
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
