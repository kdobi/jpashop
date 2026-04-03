package jpabook.jpashop;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional // 테스트 케이스에서 트랜젝션은 바로 록백해버림
public class MemberRepositoryTest {

    @Autowired  MemberRepository memberRepository;

    // 나중에 자주 사용하는 코드 Live Templates에서 커스텀 해보기
    @Test
    public void testMember() throws Exception{
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then ‼️ 스프링 데스트 Assert 봐보기
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

        // ➕‼️ True / 같은 트랜젝션 안에서 조회하면 영속성 컨텍스트가 같음
        // 그리고 그 안에서는 ID가 같으면 같은 엔티티로 봄. 그냥 JPA 레전드임
        // 1차캐시와 관련한 부분 좀더 깊게 공부해보자 
        Assertions.assertThat(findMember).isEqualTo(member);

    }
}