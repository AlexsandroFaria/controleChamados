/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.model;

/**
 *
 * @author alafaria
 */
public class ChamadosFechados{
    
    private int idChamadoFechado;
    private int numeroChamado;
    private int contrato;
    private String nomeCliente;
    private String mensagemFechamento;
    private String status;
    private String dataFechamento; 

    public int getIdChamadoFechado() {
        return idChamadoFechado;
    }

    public void setIdChamadoFechado(int idChamadoFechado) {
        this.idChamadoFechado = idChamadoFechado;
    }

    public int getNumeroChamado() {
        return numeroChamado;
    }

    public void setNumeroChamado(int numeroChamado) {
        this.numeroChamado = numeroChamado;
    }

    public int getContrato() {
        return contrato;
    }

    public void setContrato(int contrato) {
        this.contrato = contrato;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getMensagemFechamento() {
        return mensagemFechamento;
    }

    public void setMensagemFechamento(String mensagemFechamento) {
        this.mensagemFechamento = mensagemFechamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
    
}
