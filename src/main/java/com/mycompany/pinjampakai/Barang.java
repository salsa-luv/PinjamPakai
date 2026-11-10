/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pinjampakai;

/**
 *
 * @author ACER
 */

public class Barang extends Fasilitas {
    private int jumlah;

    public Barang(String kode, String nama, String status, int jumlah) {
        super(kode, nama, status);
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jumlah         : " + jumlah);
    }
}
