package com.algaworks.cursojsf2.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.algaworks.cursojsf2.logs.Logs;

@ManagedBean(name = "estoqueBean")
@ViewScoped
public class EstoqueBean {
    private static final ActionEvent ActionEvent = null;
    ItemEstoque item;
    List<ItemEstoque> listaProdutos;
    Logs log;

    public EstoqueBean() {
        this.listaProdutos = new ArrayList<ItemEstoque>();
        this.log = new Logs();
        this.item = new ItemEstoque();
    }

    public void gravar() {
        try {
            if (validarCampos()) {
                listaProdutos.add(item);
                log.logAcao(null, FacesMessage.SEVERITY_INFO, "Inserido Com Sucesso!",
                        "Cadastro Realizado com Sucesso!");
            } else {
                log.logAcao(null, FacesMessage.SEVERITY_ERROR, "Problema na Inserção!", "Campo não Informado!");
            }
        } catch (Exception e) {
            log.logAcao(null, FacesMessage.SEVERITY_ERROR, "Probrlema na Inserção!", "Erro :" + e.getMessage());
        }

    }

    private boolean validarCampos() {

        boolean camposChecados = true;
        String summaryDefault = "Campo Obrigatório!";
        try {

            if ("".equals(item.getCodigoProduto().toString()) && "".equals(item.getDescricaoProduto())
                    && "".equals(item.getQuantidade().toString()) && "".equals(item.getValorUnitario().toString())
                    && "".equals(item.getDataChecagem().toString())) {
                log.logAcao(null, FacesMessage.SEVERITY_INFO, "Campos Obrigatorios!",
                        "Campos Obrigatorios não preenchidos!");
                camposChecados = false;
            } else if ("".equals(item.getCodigoProduto().toString()) || item.getCodigoProduto() == null) {
                log.logAcao("frm_estoque:ipt_codigo", FacesMessage.SEVERITY_INFO, summaryDefault,
                        "Codigo do Produto deve ser informado!");

            } else if ("".equals(item.getDescricaoProduto())) {
                log.logAcao("frm_estoque:ipt_descricao", FacesMessage.SEVERITY_INFO, summaryDefault,
                        "Descrição do Produto deve ser informado!");

            } else if (item.getQuantidade() == null) {
                log.logAcao("frm_estoque:ipt_quantidade", FacesMessage.SEVERITY_INFO, summaryDefault,
                        "Quantidade do Produto deve ser informado!");

            } else if (item.getValorUnitario() == null) {
                log.logAcao("frm_estoque:ipt_valor", FacesMessage.SEVERITY_INFO, summaryDefault,
                        "Valor Unitário deve ser informado!");
            } else if (item.getDataChecagem() == null) {
                log.logAcao("frm_estoque:ipt_data_checagem", FacesMessage.SEVERITY_INFO, summaryDefault,
                        "Data Checagem deve ser informado!");
            }

        } catch (Exception e) {
            
            log.logAcao(null, FacesMessage.SEVERITY_ERROR, "Erro!", "Erro Detalhado:" + e.getMessage());
            camposChecados = false;
        }
        return camposChecados;
    }

    public EstoqueBean(ItemEstoque item) {
        this.item = item;
    }

    public ItemEstoque getItem() {
        return item;
    }

    public void setItem(ItemEstoque item) {
        this.item = item;
    }

}
