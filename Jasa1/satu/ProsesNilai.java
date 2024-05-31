import java.io.*;
import java.util.*;

public class ProsesNilai {

  private List<Mahasiswa> mahasiswaList;

  public ProsesNilai() {
    this.mahasiswaList = new ArrayList<>();
  }

  public void tambahMahasiswa(Mahasiswa m) {
    mahasiswaList.add(m);
  }

  public void simpanDataKeFile(String fileName) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      for (Mahasiswa m : mahasiswaList) {
        writer.write(
          m.getNama() +
          "," +
          m.getNpm() +
          "," +
          m.getIp() +
          "," +
          m.getNilai() +
          "," +
          m.getKeterangan()
        );
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void bacaDataDariFile(String fileName) {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        String nama = data[0];
        int npm = Integer.parseInt(data[1]);
        int ip = Integer.parseInt(data[2]);
        Mahasiswa m = new Mahasiswa(nama, npm, ip);
        mahasiswaList.add(m);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void evaluasiIP() {
    for (Mahasiswa m : mahasiswaList) {
      while (!m.getKeterangan().equals("Lulus")) {
        int newIp = m.getIp() + (int) (Math.random() * 10);
        m.updateIp(newIp);
        System.out.println(
          "Update IP Mahasiswa " +
          m.getNama() +
          " menjadi " +
          m.getIp() +
          " (" +
          m.getKeterangan() +
          ")"
        );
      }
    }
  }
}
