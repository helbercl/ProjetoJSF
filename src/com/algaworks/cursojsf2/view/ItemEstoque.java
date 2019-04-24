package com.algaworks.cursojsf2.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ItemEstoque implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long codigoProduto;
    private String descricaoProduto;
    private Short quantidade;
    private BigDecimal valorUnitario;
    private Date dataChecagem;
    
    public Long getCodigoProduto() {
        return codigoProduto;
    }
    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    public String getDescricaoProduto() {
        return descricaoProduto;
    }
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
    public Short getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Short quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public Date getDataChecagem() {
        return dataChecagem;
    }
    public void setDataChecagem(Date dataChecagem) {
        this.dataChecagem = dataChecagem;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}
