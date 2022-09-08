package hello.hellospring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryRepositoryTest {

	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		
		repository.clearStore();
	}
	
	@Test
	public void save() {
		
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		
		Assertions.assertEquals(result, member); // 같으면 테스트 통과. 다르면 기댓값과 Actual값을 반환
		
	}
	
	@Test
	public void findByName() {
		
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member1.setName("spring2");
		repository.save(member2);
		
		
		Member result = repository.finByName(member1.getName()).get();
		
		Assertions.assertEquals(result, member1);
		
	} 
	
	@Test
	public void findAll() {
		
		
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member1.setName("spring2");
		repository.save(member2);
		
		Member result = repository.finByName(member1.getName()).get();
		
		Assertions.assertEquals(result,member1);
		
	}
	

}
