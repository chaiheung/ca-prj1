package com.caprj1.mapper;

import com.caprj1.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Insert("""
            INSERT INTO member (email, password, nickname)
            VALUES (#{email}, #{password}, #{nickname})
            """)
    int insert(Member member);

    @Select("""
            SELECT *
            FROM member
            ORDER BY id DESC
            """)
    List<Member> selectAll();

    @Select("""
            SELECT *
            FROM member
            WHERE id = #{id}
            """)
    Member selectById(Integer id);

    @Delete("""
            DELETE FROM member
            WHERE id = #{id}
            """)
    int deleteById(Integer id);

    @Update("""
            UPDATE member 
            SET email=#{email}, 
                password=#{password}, 
                nickname=#{nickname} 
            WHERE id = #{id}
            """)
    int update(Member member);

    @Select("""
            SELECT * FROM member
            WHERE email = #{email}
            """)
    Member selectByEmail(String email);
}
