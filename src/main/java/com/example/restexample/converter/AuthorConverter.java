//package com.example.restexample.converter;
//
//import com.example.restexample.dto.AuthorResponseDto;
//import com.example.restexample.dto.CreateAuthorDto;
//import com.example.restexample.model.Author;
//import lombok.experimental.UtilityClass;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@UtilityClass
//public class AuthorConverter {
//
//    public  Author converDtoToEntity(CreateAuthorDto createAuthorDto) {
//
//        Author author = new Author();
//        author.setName(createAuthorDto.getName());
//        author.setSurname(createAuthorDto.getSurname());
//        author.setEmail(createAuthorDto.getEmail());
//        author.setGender(createAuthorDto.getGender());
//
//        return author;
//    }
//
//    public  AuthorResponseDto convertEntityToResponseDto(Author author) {
//        return AuthorResponseDto.builder()
//                .id(author.getId())
//                .name(author.getName())
//                .surname(author.getSurname())
//                .gender(author.getGender())
//                .build();
//    }
//
//    public  List<AuthorResponseDto> convertEntitiesToResponseDtos(List<Author> all) {
//        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
//        for (Author author : all) {
//            authorResponseDtos.add(convertEntityToResponseDto(author));
//        }
//        return authorResponseDtos;
//
//    }
//
//
//}
