package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.model.ListDocument;
import pro.sky.botanimalshelter.service.ListDocumentService;
import pro.sky.botanimalshelter.volunteercrud.crudutils.ListDocumentDto;

import java.util.List;

/**
 * Контроллер для работы с БД документов -- Documents DB CRUD Controller
 */
@RestController
@RequestMapping("/doc")
@Tag(name = "Контроллер для работы с БД докуметов -- Documents DB CRUD Controller")
public class DocsController {

    private final ListDocumentService listDocumentService;

    public DocsController(ListDocumentService listDocumentService) {
        this.listDocumentService = listDocumentService;
    }

    @Operation(summary = "Просмотр списка документов ListDocument -- View ListDocument entities")
    @GetMapping("")
    public List<ListDocumentDto> viewAllListDocuments() {
        return listDocumentService.findAllListDocuments().stream()
                .map(ListDocumentDto::dto).toList();
    }

    @Operation(summary = "Просмотр документа ListDocument с указанным идентификатором -- View ListDocument with id as provided")
    @GetMapping("/{id}")
    public ListDocumentDto viewListDocument(
            @Parameter(name = "id", description = "идентификатор сущности ListDocument",
                    example = "4")
            @PathVariable Long id) {
        return ListDocumentDto.dto(listDocumentService.findById(id));
    }

    @PostMapping("/new")
    @Operation(summary = "Создание документа ListDocument -- Create New ListDocument")
    public ListDocumentDto createListDocument(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "data transfer object for listDocument, please refer to ListDocumentDto class for more information")
            @RequestBody ListDocumentDto listDocumentDto) {
        return listDocumentService.createListDocument(listDocumentDto);

    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактирование документа ListDocument с указанным идентификатором -- Edit ListDocument with id as provided")
    public ListDocumentDto editListDocument(
            @Parameter(name = "id", description = "ListDocumentDto entity database Id") @PathVariable(name = "id") Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "data transfer object for ListDocument")
            @RequestBody() ListDocumentDto listDocumentDto) {
        return listDocumentService.updateListDocument(id, listDocumentDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление документа ListDocument с указанным идентификатором "
            + "-- Delete ListDocument with id as provided")
    public ListDocumentDto deleteListDocument(
            @Parameter(name = "id", description = "ListDocument entity database id")
            @PathVariable Long id) {
        return listDocumentService.deleteListDocument(id);
    }


}
