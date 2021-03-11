import java.util.Comparator;

public class Karyawan {
    String kode, nama, jenis_kelamin, jabatan;
    int gaji;
    public Karyawan(String kode, String nama, String jenis_kelamin, String jabatan, int gaji) {
        super();
        this.kode = kode;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.jabatan = jabatan;
        this.gaji = gaji;
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
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
    public String getJabatan() {
        return jabatan;
    }
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    public int getGaji() {
        return gaji;
    }
    public void setGaji(int gaji) {
        this.gaji = gaji;
    }
    public static Comparator<Karyawan> KaryawanNameComparator = (Karyawan s1, Karyawan s2) -> {
        String StudentName1 = s1.getNama().toUpperCase();
        String StudentName2 = s2.getNama().toUpperCase();
        
        return StudentName1.compareTo(StudentName2);
    };
}
