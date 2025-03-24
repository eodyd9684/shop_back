package com.green.book_shop.book.controller;

import com.green.book_shop.book.dto.BookDTO;
import com.green.book_shop.book.service.BookService;
import com.green.book_shop.util.UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;
  private final UploadUtil uploadUtil;

  //도서 등록 api
  //post ~/books
  @PostMapping("")
  public void insertBook(BookDTO bookDTO
                        , @RequestParam(name = "mainImg", required = true) MultipartFile mainImg
                        , @RequestParam(name = "subImg", required = true) MultipartFile subImg
  ){
    //첨부파일(도서 이미지) 업로드
    uploadUtil.fileUpload(mainImg);
    uploadUtil.fileUpload(subImg);

    //BOOK 테이블에 데이터 INSERT
    bookService.insertBook(bookDTO);

    //BOOK_IMG 테이블에 도서 이미지 정보 INSERT
  }
}
