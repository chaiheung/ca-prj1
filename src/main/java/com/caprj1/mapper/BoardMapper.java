package com.caprj1.mapper;

import com.caprj1.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    @Insert(
            """
                    INSERT INTO board ( title, content, writer )
                    VALUES (#{title}, #{content}, #{writer})
                    """
    )
    int insert(Board board);
}
