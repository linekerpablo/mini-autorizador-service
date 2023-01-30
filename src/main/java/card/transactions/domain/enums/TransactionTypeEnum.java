package card.transactions.domain.enums;

public enum TransactionTypeEnum {
    SALDO_INSUFICIENTE("INSUFFICIENT_BALANCE"), SENHA_INVALIDA("PASSWORD_INVALID"), CARTAO_INEXISTENTE("CARD_NOT_FOUND");

    public String value;

    TransactionTypeEnum(String value) {
        this.value = value;
    }
}
