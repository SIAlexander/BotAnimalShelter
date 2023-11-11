package pro.sky.botanimalshelter.model;

/**
 * <b>Conclusion</b> написан для использования в журнале бота для записи результата выполнения действия
 * или процедуры (нескольких взаимосвязанных действий в соответствии с Техническим заданием)
 * <br> DONE выполнено успешно,
 * <br>FAILED выполнено неудачно,
 * <br>PET_IS_GIVEN_ON_TRIAL_ADOPTION питомца передали на пробное усыновление,
 * <br>ADOPTION_APPROVED усыновление утверждено, питомец передан новому владельцу на постоянной основе,
 * <br>NOT_FINISHED не закончено
 * <br><br>Коллеги! Дайте знать, если вам будут нужны какие-нибудь еще значения
 */
public enum Conclusion {
    DONE,
    FAILED,
    PET_IS_GIVEN_ON_TRIAL_ADOPTION,
    ADOPTION_APPROVED,
    NOT_FINISHED
}
