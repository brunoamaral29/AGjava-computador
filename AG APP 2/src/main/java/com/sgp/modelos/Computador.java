package com.sgp.modelos;

public class Computador {

    private String marca;
    private String processador;
    private int memoriaRam;
    private double preço;

    public Computador() {
        this.marca = "Dell";
        this.processador = "Intel Core i5";
        this.memoriaRam = 8;
        this.preço = 2500.0;
    }

    public Computador(String marca, String processador, int memoriaRam, double preço) {
        this.marca = marca;
        this.processador = processador;
        this.memoriaRam = memoriaRam;
        this.preço = preço;
    }

    public void exibirEspecificacoes() {
        System.out.println("Especificações do Computador:");
        System.out.println("Marca: " + marca);
        System.out.println("Processador: " + processador);
        System.out.println("Memória RAM: " + memoriaRam + " GB");
        System.out.println("Preço: R$ " + String.format("%.2f", preço));
    }

    public boolean precisaUpgrade(int ramMinima) {
        return this.memoriaRam < ramMinima;
    }

    public String getMarca() {
        return marca;
    }

    public String getProcessador() {
        return processador;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public double getPreço() {
        return preço;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    @Override
    public String toString() {
        return "Computador [marca=" + marca + ", processador=" + processador +
               ", memoriaRam=" + memoriaRam + "GB, preço=R$" + String.format("%.2f", preço) + "]";
    }
}