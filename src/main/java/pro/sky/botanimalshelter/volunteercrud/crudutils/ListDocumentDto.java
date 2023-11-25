package pro.sky.botanimalshelter.volunteercrud.crudutils;

import pro.sky.botanimalshelter.model.ListDocument;

/**
 * Объект передачи данных сущности ListDocument -- ListDocument data transfer object
 */
public class ListDocumentDto {
    private Long id;
    private String document;
    private Long shelterId;

    public ListDocumentDto(Long id, String document, Long shelterId) {
        this.id = id;
        this.document = document;
        this.shelterId = shelterId;
    }

    public ListDocumentDto() {
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

    /**
     * Создаем экземпляр объекта передачи данных информационного документа приюта -- Make ListDocument data transfer object from ListDocument entity
     *
     * @param listDocument nullable
     * @return ListDocumentDto instance or null if null argument provided
     */
    public static ListDocumentDto dto(ListDocument listDocument) {
        if (listDocument == null) {
            return null;
        }
        ListDocumentDto listDocumentDto = new ListDocumentDto();
        listDocumentDto.document = listDocument.getDocument();
        listDocumentDto.id = listDocument.getId();
        listDocumentDto.shelterId = listDocument.getShelter().getId();

        return listDocumentDto;

    }

}
