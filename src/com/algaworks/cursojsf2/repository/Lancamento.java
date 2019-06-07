package com.algaworks.cursojsf2.repository;

import java.util.List;

import com.algaworks.cursojsf2.model.Lancamentos;

public interface Lancamento {
  public List<Lancamentos> todos();
  public Lancamentos comDadosIguais(Lancamentos lancamento);
  public Lancamentos porCodigo(Integer codigo);
  
  public Lancamento guardar(Lancamentos lancamento);
  public void remover(Lancamentos lancamento);
}
