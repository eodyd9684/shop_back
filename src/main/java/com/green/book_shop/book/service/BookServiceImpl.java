package com.green.book_shop.book.service;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
  private final BookMapper bookMapper;

  //카테고리 목록 조회
  @Override
  public List<BookCategoryDTO> selectCategoryList() {
    return bookMapper.selectCategoryList();
  }

  //도서 등록
  @Override
  public void insertBook(BookDTO bookDTO) {
    bookMapper.insertBook(bookDTO);
  }

  //카테고리 수정
  @Override
  public void updateCate(BookCategoryDTO bookCategoryDTO) {
  bookMapper.updateCate(bookCategoryDTO);
  }
  //카테고리 삭제
  @Override
  public void deleteCate(int cateCode) {
  bookMapper.deleteCate(cateCode);
  }
  //카테고리 등록기능
  @Override
  public int isUsableCateName(String cateName) {
    int result = 0;
    //카테고리명 중복확인 한다
    //cateName이 null이면 사용가능한 카테고리명
    //cateName이 null이 아니면 사용 불가능한 카테고리명
    String selectedCateName = bookMapper.isUsableCateName(cateName);
    //만약 중복이 아니면 카테고리를 등록한다.
    if(selectedCateName == null){
      //카테고리 등록 실행
     result = bookMapper.insertCate(cateName);
    }
    return result;
  }


}
