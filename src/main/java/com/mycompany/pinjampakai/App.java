package com.mycompany.pinjampakai;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat objek fasilitas
        Barang barang1 = new Barang(
            "B001", "Proyektor", "Tersedia", 2
        );

        Barang barang2 = new Barang(
            "B002", "Kabel HDMI", "Tersedia", 5
        );

        Ruangan ruangan1 = new Ruangan(
            "R001", "Ruang Seminar", "Tersedia", 40
        );

        Ruangan ruangan2 = new Ruangan(
            "R002", "Ruang Rapat", "Tersedia", 20
        );

        int pilihan;

        System.out.println("==================================");
        System.out.println("       SISTEM PINJAMPAKAI");
        System.out.println(" Peminjaman Barang dan Ruangan");
        System.out.println("==================================");

        while (true) {
            System.out.println("\nMENU UTAMA");
            System.out.println("1. Lihat Daftar Fasilitas");
            System.out.println("2. Ajukan Peminjaman");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\nDAFTAR BARANG");
                    barang1.tampilkanInfo();
                    System.out.println("--------------------------");
                    barang2.tampilkanInfo();

                    System.out.println("\nDAFTAR RUANGAN");
                    ruangan1.tampilkanInfo();
                    System.out.println("--------------------------");
                    ruangan2.tampilkanInfo();
                    break;

                case 2:
                    System.out.println("\nJENIS FASILITAS");
                    System.out.println("1. Barang");
                    System.out.println("2. Ruangan");
                    System.out.print("Pilih jenis fasilitas: ");

                    int jenis = input.nextInt();
                    input.nextLine();

                    if (jenis == 1 || jenis == 2) {
                        System.out.print("Masukkan nama peminjam: ");
                        String nama = input.nextLine();

                        System.out.print("Masukkan tujuan peminjaman: ");
                        String tujuan = input.nextLine();

                        System.out.println("\nPENGAJUAN PEMINJAMAN");
                        System.out.println("Nama Peminjam : " + nama);
                        System.out.println("Tujuan        : " + tujuan);

                        if (jenis == 1) {
                            System.out.println("Jenis         : Barang");
                        } else {
                            System.out.println("Jenis         : Ruangan");
                        }

                        System.out.println("Status        : Menunggu Persetujuan");
                        System.out.println("Pengajuan berhasil dicatat.");
                    } else {
                        System.out.println("Pilihan jenis fasilitas tidak valid.");
                    }
                    break;

                case 3:
                    System.out.println("\nTerima kasih telah menggunakan PinjamPakai.");
                    input.close();
                    return;

                default:
                    System.out.println("Pilihan menu tidak valid.");
            }
        }
    }
}