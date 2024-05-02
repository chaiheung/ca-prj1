package com.caprj1.mapper;

import com.caprj1.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    @Insert("""
            INSERT INTO member (email, password, nickname)
            VALUES (#{email}, #{password}, #{nickname})
            """)
    int insert(Member member);
}
