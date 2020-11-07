package com.xx.dao;

import com.xx.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Book findById(long id);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    List<Book> findSome(String name);

    /**
     * 查询所有
     * @return
     */
    List<Book> findAll(@Param("name")String name);

    /**
     * 减少库存 判断是否还有库存
     * @param bookId
     * @return
     */
    int reduceNumber(long bookId);

    int delBookById(Integer bookId);

    int addBook(@Param("name") String name, @Param("introd") String introd, @Param("number") int number);
}
