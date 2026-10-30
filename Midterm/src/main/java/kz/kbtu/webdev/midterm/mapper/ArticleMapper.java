package kz.kbtu.webdev.midterm.mapper;

import kz.kbtu.webdev.midterm.dto.SaveArticleDto;
import kz.kbtu.webdev.midterm.dto.ViewArticleDto;
import kz.kbtu.webdev.midterm.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    @Mapping(source = "views", target = "numberOfViews")
    @Mapping(source = "postedAt", target = "postDate")
    @Mapping(source = "id", target = "identifier")
    ViewArticleDto toDto(News n);

    News toEntity(SaveArticleDto dto);

    List<ViewArticleDto> toDtoList(List<News> news);
}
