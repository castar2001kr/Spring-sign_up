package hello.hellospring.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;


public class MemberService {

	private final MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		
		
		this.memberRepository=memberRepository;
		
	}
	
	
	
	
	/*ȸ�� ����*/
	public Long join(Member member) {
		//���� �̸��� ȸ�� x
		
//		Optional<Member> result = memberRepository.finByName(member.getName());
//		result.ifPresent(m->{
//			throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
//			
//		});
		
		
		
		memberRepository.finByName(member.getName()) //�ߺ� �˻�
		.ifPresent(m->{
			throw new IllegalStateException("�̹� �����ϴ� ȸ���Դϴ�.");
			
		});
		
		memberRepository.save(member); //JOIN
		
		return member.getId();
	}
	
	
	public Optional<Member> findOne(Long id) {
		
		return memberRepository.findById(id);
		
	}
	
	
	/*��ü ȸ�� ��ȸ*/
	public List<Member> findMembers()
	{	
		return memberRepository.findAll();
	}
	
	
	
	
	
}