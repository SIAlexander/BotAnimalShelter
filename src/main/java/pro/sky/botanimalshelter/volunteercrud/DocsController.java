package pro.sky.botanimalshelter.volunteercrud;

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

    @GetMapping("")
    public List<ListDocumentDto> viewAllListDocuments() {
        return listDocumentService.findAllListDocuments().stream()
                .map(ListDocumentDto::dto).toList();
    }

    @GetMapping("/{id}")
    public ListDocument viewListDocument(@PathVariable Long id) {
        return listDocumentService.findById(id);
    }

    @PostMapping("/new")
    public ListDocumentDto createListDocument(@RequestBody ListDocumentDto listDocumentDto) {
        return listDocumentService.createListDocument(listDocumentDto);

    }

    @PutMapping("/{id}")
    public ListDocumentDto editListDocument(@PathVariable(name = "id") Long id, ListDocumentDto listDocumentDto) {
        return listDocumentService.updateListDocument(id, listDocumentDto);
    }

    @DeleteMapping("/{id}")
    public ListDocumentDto deleteListDocument(@PathVariable Long id) {
        return listDocumentService.deleteListDocument(id);
    }


}
