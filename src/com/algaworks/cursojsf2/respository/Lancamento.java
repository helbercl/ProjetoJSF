package com.algaworks.cursojsf2.respository;

import com.algaworks.cursojsf2.model.Lancamentos;

public interface Lancamento {
  public java.util.List<Lancamentos> todos();
  public Lancamentos comDadosIguais(com.algaworks.cursojsf2.model.Lancamentos lancamento);
  public com.algaworks.cursojsf2.model.Lancamentos porCodigo(Integer codigo);
  
  public Lancamento guardar(com.algaworks.cursojsf2.model.Lancamentos lancamento);
  public void remover(com.algaworks.cursojsf2.model.Lancamentos lancamento);
}
