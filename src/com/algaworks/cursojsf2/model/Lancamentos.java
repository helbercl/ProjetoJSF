package com.algaworks.cursojsf2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lancamento")
public class Lancamentos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private TipoLancamento tipo;
	private Pessoas pessoa;
	private String descricao;
	private BigDecimal valor;
	private Date dataVencimento;
	private boolean pago;
	private Date dataPagamento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public TipoLancamento getTipo() {
		return tipo;
	}
	@Enumerated(EnumType.STRING) // informando que se trata de um tipo enum
 	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}
	
	@ManyToOne
	@JoinColumn(name = "codigo_pessoa")
	public Pessoas getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	@Column(name="data_vencimento")
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	@Column(name="data_pagamento")
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamentos other = (Lancamentos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
}
	

}
