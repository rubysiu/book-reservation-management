package com.xx.dao;

import com.xx.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    /**
     * ����id��ѯ
     * @param id
     * @return
     */
    Book findById(long id);

    /**
     * ����name��ѯ
     * @param name
     * @return
     */
    List<Book> findSome(String name);

    /**
     * ��ѯ����
     * @return
     */
    List<Book> findAll(@Param("name")String name);

    /**
     * ���ٿ�� �ж��Ƿ��п��
     * @param bookId
     * @return
     */
    int reduceNumber(long bookId);

    int delBookById(Integer bookId);

    int addBook(@Param("name") String name, @Param("introd") String introd, @Param("number") int number);
}
