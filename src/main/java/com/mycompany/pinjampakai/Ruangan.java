/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pinjampakai;

/**
 *
 * @author ACER
 */

public class Ruangan extends Fasilitas {
    private int kapasitas;

    public Ruangan(String kode, String nama, String status, int kapasitas) {
        super(kode, nama, status);
        this.kapasitas = kapasitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kapasitas      : " + kapasitas + " orang");
    }
}
