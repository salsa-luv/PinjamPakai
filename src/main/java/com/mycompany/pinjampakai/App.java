
package com.mycompany.pinjampakai;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        // Judul aplikasi
        Label judul = new Label("SISTEM PINJAMPAKAI");
        Label subjudul = new Label("Peminjaman Barang dan Ruangan");

        // Form data peminjam
        Label labelNama = new Label("Nama Peminjam");
        TextField inputNama = new TextField();

        Label labelTujuan = new Label("Tujuan Peminjaman");
        TextField inputTujuan = new TextField();

        // Pilihan jenis fasilitas
        Label labelJenis = new Label("Pilih Jenis Fasilitas");
        Button tombolBarang = new Button("Barang");
        Button tombolRuangan = new Button("Ruangan");

        Label pilihanJenis = new Label("Belum dipilih");

        // Pilihan nama fasilitas
        Label labelFasilitas = new Label("Pilih Nama Fasilitas");
        Label pilihanFasilitas = new Label("Belum dipilih");

        Button tombolProyektor = new Button("Proyektor");
        Button tombolHDMI = new Button("Kabel HDMI");
        Button tombolSeminar = new Button("Ruang Seminar");
        Button tombolRapat = new Button("Ruang Rapat");

        // Awalnya pilihan fasilitas belum aktif
        tombolProyektor.setDisable(true);
        tombolHDMI.setDisable(true);
        tombolSeminar.setDisable(true);
        tombolRapat.setDisable(true);

        // Input jumlah barang
        Label labelJumlah = new Label("Jumlah Barang");
        TextField inputJumlah = new TextField();
        inputJumlah.setPromptText("Isi jumlah barang");

        // Tombol jenis fasilitas
        tombolBarang.setOnAction(event -> {
            pilihanJenis.setText("Barang");
            pilihanFasilitas.setText("Belum dipilih");

            tombolProyektor.setDisable(false);
            tombolHDMI.setDisable(false);
            tombolSeminar.setDisable(true);
            tombolRapat.setDisable(true);
        });

        tombolRuangan.setOnAction(event -> {
            pilihanJenis.setText("Ruangan");
            pilihanFasilitas.setText("Belum dipilih");

            tombolProyektor.setDisable(true);
            tombolHDMI.setDisable(true);
            tombolSeminar.setDisable(false);
            tombolRapat.setDisable(false);
        });

        // Tombol pilihan fasilitas
        tombolProyektor.setOnAction(event -> {
            pilihanFasilitas.setText("Proyektor");
        });

        tombolHDMI.setOnAction(event -> {
            pilihanFasilitas.setText("Kabel HDMI");
        });

        tombolSeminar.setOnAction(event -> {
            pilihanFasilitas.setText("Ruang Seminar");
        });

        tombolRapat.setOnAction(event -> {
            pilihanFasilitas.setText("Ruang Rapat");
        });

        // Tombol pengajuan
        Button tombolAjukan = new Button("Ajukan Peminjaman");

        tombolAjukan.setOnAction(event -> {

            String nama = inputNama.getText().trim();
            String tujuan = inputTujuan.getText().trim();
            String jenis = pilihanJenis.getText();
            String fasilitas = pilihanFasilitas.getText();

            // Validasi data
            if (nama.isEmpty() || tujuan.isEmpty()
                    || jenis.equals("Belum dipilih")
                    || fasilitas.equals("Belum dipilih")) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Peringatan");
                alert.setHeaderText("Data Belum Lengkap");
                alert.setContentText(
                    "Silakan lengkapi semua data pengajuan!"
                );
                alert.showAndWait();

            } else {

                String jumlah = "-";

                // Validasi jumlah barang
                if (jenis.equals("Barang")) {

                    try {
                        int nilaiJumlah = Integer.parseInt(
                            inputJumlah.getText().trim()
                        );

                        if (nilaiJumlah <= 0) {
                            throw new NumberFormatException();
                        }

                        jumlah = String.valueOf(nilaiJumlah);

                    } catch (NumberFormatException e) {

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Peringatan");
                        alert.setHeaderText("Jumlah Tidak Valid");
                        alert.setContentText(
                            "Masukkan jumlah barang berupa angka lebih dari 0!"
                        );
                        alert.showAndWait();

                        return;
                    }
                }

                // Menampilkan hasil pengajuan
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pengajuan Berhasil");
                alert.setHeaderText("Data Peminjaman Berhasil Dicatat");

                alert.setContentText(
                    "Nama Peminjam : " + nama +
                    "\nTujuan : " + tujuan +
                    "\nJenis Fasilitas : " + jenis +
                    "\nNama Fasilitas : " + fasilitas +
                    "\nJumlah : " + jumlah +
                    "\nStatus : Menunggu Persetujuan"
                );

                alert.showAndWait();
            }
        });

        // Mengatur form menggunakan GridPane
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(12);

        form.add(labelNama, 0, 0);
        form.add(inputNama, 1, 0);

        form.add(labelTujuan, 0, 1);
        form.add(inputTujuan, 1, 1);

        // Layout pilihan fasilitas
        HBox pilihanJenisBox = new HBox(10);
        pilihanJenisBox.getChildren().addAll(
            tombolBarang, tombolRuangan
        );

        HBox pilihanBarangBox = new HBox(10);
        pilihanBarangBox.getChildren().addAll(
            tombolProyektor, tombolHDMI
        );

        HBox pilihanRuanganBox = new HBox(10);
        pilihanRuanganBox.getChildren().addAll(
            tombolSeminar, tombolRapat
        );

        // Mengatur tampilan utama
        VBox layout = new VBox(12);
        layout.setPadding(new Insets(25));

        layout.getChildren().addAll(
            judul,
            subjudul,
            form,
            labelJenis,
            pilihanJenisBox,
            pilihanJenis,
            labelFasilitas,
            pilihanBarangBox,
            pilihanRuanganBox,
            pilihanFasilitas,
            labelJumlah,
            inputJumlah,
            tombolAjukan
        );

        // Membuat jendela aplikasi
        Scene scene = new Scene(layout, 500, 550);

        stage.setTitle("PinjamPakai");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}