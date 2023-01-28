package card.transactions.domain.enums;

public enum TransactionTypeEnum {
    INSUFFICIENT_BALANCE("SALDO_INSUFICIENTE"), PASSWORD_INVALID("SENHA_INVALIDA"), CARD_NOT_FOUND("CARTAO_INEXISTENTE");

    public String value;

    TransactionTypeEnum(String value) {
        this.value = value;
    }
}
