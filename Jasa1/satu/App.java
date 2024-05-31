import java.io.*;
import java.util.*;

public class App {

  public static void main(String[] args) {
    ProsesNilai proses = new ProsesNilai();

    // Contoh input data
    proses.tambahMahasiswa(new Mahasiswa("John Doe", 2023123456, 85));
    proses.tambahMahasiswa(new Mahasiswa("Jane Smith", 2023123457, 75));
    proses.tambahMahasiswa(new Mahasiswa("Alice Johnson", 2023123458, 45));
    proses.tambahMahasiswa(new Mahasiswa("Bob Brown", 2023123459, 35));

    // Simpan data ke file
    proses.simpanDataKeFile("mahasiswa.txt");

    // Baca data dari file
    proses.bacaDataDariFile("mahasiswa.txt");

    // Evaluasi IP
    proses.evaluasiIP();

    // Simpan hasil evaluasi ke file
    proses.simpanDataKeFile("mahasiswa_evaluasi.txt");
  }
}
