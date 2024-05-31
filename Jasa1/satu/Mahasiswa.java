public class Mahasiswa {

    private String nama;
    private int npm;
    private int ip;
  
    public Mahasiswa(String nama, int npm, int ip) {
      this.nama = nama;
      this.npm = npm;
      this.ip = ip;
    }
  
    public String getNama() {
      return nama;
    }
  
    public int getNpm() {
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
      if (ip >= 90) {
        return "Lulus";
      } else if (ip >= 80) {
        return "Lulus";
      } else if (ip >= 60) {
        return "Lulus ala kadarnya";
      } else if (ip >= 40) {
        return "Perlu Diperbaiki";
      } else {
        return "Tidak Lulus";
      }
    }
  
    public void updateIp(int newIp) {
      this.ip = newIp;
    }
  }