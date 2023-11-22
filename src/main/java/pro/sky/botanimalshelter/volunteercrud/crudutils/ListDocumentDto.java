package pro.sky.botanimalshelter.volunteercrud.crudutils;

/**
 * Объект передачи данных сущности ListDocument -- ListDocument data transfer object
 */
public class ListDocumentDto {
    private Long id;
    private String document;
    private Long shelterId;

    public ListDocumentDto() {
    }

    public ListDocumentDto(Long id, String document, Long shelterId) {
        this.id = id;
        this.document = document;
        this.shelterId = shelterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Long getShelterId() {
        return shelterId;
    }

    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }
}
