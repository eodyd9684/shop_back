package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookCategoryDTO;
import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class BookCategoryController {
  private final BookService bookService;

  //카테고리 목록 조회 api
  //get ~/categories
  @GetMapping("")
  public List<BookCategoryDTO> selectCategoryList() {
    return bookService.selectCategoryList();
  }

  //카테고리 등록 api
  //post ~/categories
  @PostMapping("")
  public int insertCategory(@RequestBody BookCategoryDTO bookCategoryDTO){
    //등록 성공 -> 1 리턴
    //등록 안했으면 -> 0 리턴
   return bookService.isUsableCateName(bookCategoryDTO.getCateName());
  }
  //카테고리 수정
  @PutMapping("/{cateCode}")
  public void updateCate(@RequestBody BookCategoryDTO bookCategoryDTO, @PathVariable("cateCode") int cateCode) {
    bookCategoryDTO.setCateCode(cateCode);
    bookService.updateCate(bookCategoryDTO);
  }
  //카테고리 삭제
  @DeleteMapping("/{cateCode}")
  public void deleteCate(@PathVariable("cateCode") int cateCode) {
    bookService.deleteCate(cateCode);
  }

}
