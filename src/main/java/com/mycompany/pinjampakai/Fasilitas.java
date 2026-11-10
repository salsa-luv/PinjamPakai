/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pinjampakai;

/**
 *
 * @author ACER
 */

public class Fasilitas {
    private String kode;
    private String nama;
    private String status;

    public Fasilitas(String kode, String nama, String status) {
        this.kode = kode;
        this.nama = nama;
        this.status = status;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void tampilkanInfo() {
        System.out.println("Kode Fasilitas : " + kode);
        System.out.println("Nama Fasilitas : " + nama);
        System.out.println("Status         : " + status);
    }
}
