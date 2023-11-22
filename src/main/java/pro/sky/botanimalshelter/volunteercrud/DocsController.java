package pro.sky.botanimalshelter.volunteercrud;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pro.sky.botanimalshelter.model.ListDocument;
import pro.sky.botanimalshelter.service.ListDocumentService;
import pro.sky.botanimalshelter.volunteercrud.crudutils.ListDocumentDto;

import java.util.List;

/**
 * Контроллер для работы с БД докуметов -- Documents DB CRUD Controller
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
    public List<ListDocument> viewAllListDocuments() {
        return listDocumentService.findAllListDocuments();
    }

    @GetMapping("/{id}")
    public ListDocument viewListDocument(@PathVariable Long id) {
        return listDocumentService.findById(id);
    }

    @PostMapping("/new")
    public ListDocument createListDocument(ListDocumentDto listDocumentDto) {
        return listDocumentService.createListDocument(listDocumentDto);

    }


}
