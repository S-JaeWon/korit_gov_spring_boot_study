package com.korit.korit_gov_spring_boot_study.service;

import com.korit.korit_gov_spring_boot_study.dto.Request.AddMemberReqDto;
import com.korit.korit_gov_spring_boot_study.entity.Member;
import com.korit.korit_gov_spring_boot_study.repository.MemberRepository;

import java.util.List;

public class MemberService {
    private static MemberService instance;
    private MemberRepository memberRepository;

    private MemberService() {
        memberRepository = MemberRepository.getInstance();
    }

    public static MemberService getInstance() {
        if (instance == null) {
            instance = new MemberService();
        }
        return instance;
    }

    public boolean isDupleName(String name) {
        return memberRepository.searchName(name) != null;
    }

    public void addMember(AddMemberReqDto addMemberReqDto) {
        memberRepository.addMember(addMemberReqDto.toEntity());
    }

    public List<Member> getMemberAll() {
        return memberRepository.members();
    }
}
