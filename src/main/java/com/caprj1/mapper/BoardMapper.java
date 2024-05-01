package com.caprj1.mapper;

import com.caprj1.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardMapper {
    @Insert(
            """
                    INSERT INTO board ( title, content, writer )
                    VALUES (#{title}, #{content}, #{writer})
                    """
    )
    int insert(Board board);

    @Select("""
            SELECT *
            FROM board
            WHERE id = #{id}
            """)
    Board selectById(Integer id);
}
