package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Sale {

    private Long operation;
    private Long client;
    private Integer quantity;
    private BigDecimal valor;
    private String status;

    public Sale(){
    }

    public Sale(Long operation, Long client, Integer quantity, BigDecimal valor) {
        this.operation = operation;
        this.client = client;
        this.quantity = quantity;
        this.valor = valor;

    }

    public Long getOperation() {
        return operation;
    }

    public void setOperation(Long operation) {
        this.operation = operation;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(operation, sale.operation) && Objects.equals(client, sale.client) && Objects.equals(quantity, sale.quantity) && Objects.equals(valor, sale.valor) && Objects.equals(status, sale.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, client, quantity, valor, status);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "operation=" + operation +
                ", client=" + client +
                ", quantity=" + quantity +
                ", valor=" + valor +
                ", status='" + status + '\'' +
                '}';
    }
}
