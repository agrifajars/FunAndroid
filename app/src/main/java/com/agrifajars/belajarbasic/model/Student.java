package com.agrifajars.belajarbasic.model;

public class Student {

    private String nama;
    private String agama;
    private String jk;

    public Student(String nama, String agama, String jk) {
        this.nama = nama;
        this.agama = agama;
        this.jk = jk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    //Constuctor
//    public Student(String nama, String agama, String jk){
//        this.nama   = nama;
//        this.agama  = agama;
//        this.jk     = jk;
//    }
}
