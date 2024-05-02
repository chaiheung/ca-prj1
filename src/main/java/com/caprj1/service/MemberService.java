package com.caprj1.service;

import com.caprj1.domain.Member;
import com.caprj1.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mapper;

    public void signup(Member member) {
        mapper.insert(member);
    }
}
