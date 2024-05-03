package com.caprj1.mapper;

import com.caprj1.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert(
            """
                    INSERT INTO board ( title, content, writer )
                    VALUES (#{title}, #{content}, #{writer})
                    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Board board);

    @Select("""
            SELECT *
            FROM board
            WHERE id = #{id}
            """)
    Board selectById(Integer id);

    @Select("""
            SELECT *
            FROM board
            ORDER BY id DESC

            """)
    List<Board> selectAll();

    @Delete("""
            DELETE FROM board
            WHERE id = #{id}
            """)
    int deleteById(Integer id);

    @Update("""
            UPDATE board 
            SET title=#{title}, content=#{content}, writer=#{writer}
            WHERE id = #{id}
            """)
    int update(Board board);

    @Select("""
            SELECT *
            FROM board
            ORDER BY id DESC
            LIMIT #{offset}, 10
            """)
    List<Board> selectAllbyPage(int offset);
}
