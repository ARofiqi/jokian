import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private String npm;
    private int ip;

    public Mahasiswa(String nama, String npm, int ip) {
        this.nama = nama;
        this.npm = npm;
        this.ip = ip;
    }

    public String getNama() {
        return nama;
    }

    public String getNpm() {
        return npm;
    }

    public int getIp() {
        return ip;
    }

    public String getNilai() {
        if (ip >= 90) {
            return "A";
        } else if (ip >= 80) {
            return "B";
        } else if (ip >= 60) {
            return "C";
        } else if (ip >= 40) {
            return "D";
        } else {
            return "E";
        }
    }

    public String getKeterangan() {
        String nilai = getNilai();
        if (nilai.equals("A") || nilai.equals("B") || nilai.equals("C")) {
            return "Lulus";
        } else if (nilai.equals("D")) {
            return "Perlu Diperbaiki";
        } else {
            return "Tidak Lulus";
        }
    }
}

public class PenilaianIP {
    public static void main(String[] args) {
        Mahasiswa bakti = new Mahasiswa("BAKTI WISDA PERWIRA", "22612091196", 96);

        // Menyimpan data mahasiswa ke dalam file
        saveMahasiswaData(bakti);

        // Membaca data mahasiswa dari file
        Mahasiswa[] mahasiswas = readMahasiswaData();

        if (mahasiswas != null) {
            // Menampilkan data mahasiswa
            for (Mahasiswa m : mahasiswas) {
                System.out.println("Nama: " + m.getNama());
                System.out.println("NPM: " + m.getNpm());
                System.out.println("IP: " + m.getIp());
                System.out.println("Nilai: " + m.getNilai());
                System.out.println("Keterangan: " + m.getKeterangan());
                System.out.println();
            }
        } else {
            System.out.println("Tidak ada data mahasiswa.");
        }
    }

    public static void saveMahasiswaData(Mahasiswa mahasiswa) {
        try {
            File file = new File("mahasiswa.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(mahasiswa.getNama() + "," + mahasiswa.getNpm() + "," + mahasiswa.getIp() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error occurred while saving data to file: " + e.getMessage());
        }
    }

    public static Mahasiswa[] readMahasiswaData() {
        Mahasiswa[] mahasiswas = null;
        try {
            File file = new File("mahasiswa.txt");
            Scanner scanner = new Scanner(file);
            int count = countLines(file);
            mahasiswas = new Mahasiswa[count];
            int i = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                Mahasiswa m = new Mahasiswa(data[0], data[1], Integer.parseInt(data[2]));
                mahasiswas[i] = m;
                i++;
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error occurred while reading data from file: " + e.getMessage());
        }
        return mahasiswas;
    }

    public static int countLines(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        int count = 0;
        while (scanner.hasNextLine()) {
            count++;
            scanner.nextLine();
        }
        scanner.close();
        return count;
    }
}
