class Mahasiswa {
    constructor(nama, npm, ip) {
        this.nama = nama;
        this.npm = npm;
        this.ip = ip;
    }

    getNama() {
        return this.nama;
    }

    getNpm() {
        return this.npm;
    }

    getIp() {
        return this.ip;
    }

    getNilai() {
        if (this.ip >= 90) {
            return "A";
        } else if (this.ip >= 80) {
            return "B";
        } else if (this.ip >= 60) {
            return "C";
        } else if (this.ip >= 40) {
            return "D";
        } else {
            return "E";
        }
    }

    getKeterangan() {
        const nilai = this.getNilai();
        if (nilai === "A" || nilai === "B" || nilai === "C") {
            return "Lulus";
        } else if (nilai === "D") {
            return "Perlu Diperbaiki";
        } else {
            return "Tidak Lulus";
        }
    }
}

function saveMahasiswaData(mahasiswa) {
    try {
        const fs = require('fs');
        const data = `${mahasiswa.getNama()},${mahasiswa.getNpm()},${mahasiswa.getIp()}\n`;
        fs.appendFileSync('mahasiswa.txt', data);
    } catch (error) {
        console.log("Error occurred while saving data to file: " + error.message);
    }
}

function readMahasiswaData() {
    let mahasiswas = null;
    try {
        const fs = require('fs');
        const data = fs.readFileSync('mahasiswa.txt', 'utf8').split('\n');
        const count = data.length-1;
        mahasiswas = new Array(count);
        for (let i = 0; i < count; i++) {
            const [nama, npm, ip] = data[i].split(',');
            mahasiswas[i] = new Mahasiswa(nama, npm, parseInt(ip));
        }
    } catch (error) {
        console.log("Error occurred while reading data from file: " + error.message);
    }
    return mahasiswas;
}

function countLines(file) {
    const fs = require('fs');
    const data = fs.readFileSync(file, 'utf8');
    return data.split('\n').length;
}

const bakti = new Mahasiswa("BAKTI WISDA PERWIRA", "22612091196", 96);

// Menyimpan data mahasiswa ke dalam file
saveMahasiswaData(bakti);

// Membaca data mahasiswa dari file
const mahasiswas = readMahasiswaData();

if (mahasiswas !== null) {
    // Menampilkan data mahasiswa
    for (const m of mahasiswas) {
        console.log("Nama: " + m.getNama());
        console.log("NPM: " + m.getNpm());
        console.log("IP: " + m.getIp());
        console.log("Nilai: " + m.getNilai());
        console.log("Keterangan: " + m.getKeterangan());
        console.log();
    }
} else {
    console.log("Tidak ada data mahasiswa.");
}
