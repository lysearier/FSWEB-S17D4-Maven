package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    // 1) Öğrenci tablosundaki tüm kayıtları listeleyin.
    String QUESTION_1 = "SELECT * FROM ogrenci;";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Ogrenci> findAll();

    // 2) Öğrenci tablosundaki kız öğrencileri listeleyin.
    String QUESTION_2 = "SELECT * FROM ogrenci WHERE cinsiyet = 'K';";
    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findGirls();

    // 3) Öğrenci tablosunda kaydı bulunan sınıfların adını her sınıf bir kez görüntüleyin.
    String QUESTION_3 = "SELECT DISTINCT sinif FROM ogrenci;";
    @Query(value = QUESTION_3, nativeQuery = true)
    List<String> findAllClasses();

    // 4) 10A sınıfında olan kız öğrencileri listeleyin.
    String QUESTION_4 = "SELECT * FROM ogrenci WHERE sinif = '10A' AND cinsiyet = 'K';";
    @Query(value = QUESTION_4, nativeQuery = true)
    List<Ogrenci> find10AGirls();

    // 5) Öğrenci numarası 5 ile 10 arasında olan kız öğrencileri listeleyin.
    String QUESTION_5 = "SELECT * FROM ogrenci WHERE ogrno BETWEEN 5 AND 10 AND cinsiyet = 'K' ORDER BY ad ASC;";
    @Query(value = QUESTION_5, nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();

    // 6) Öğrencileri adına göre sıralayınız (alfabetik).
    String QUESTION_6 = "SELECT * FROM ogrenci ORDER BY ad ASC;";
    @Query(value = QUESTION_6, nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();

    // 7) 10A sınıfındaki öğrencileri okul numarasına göre azalan olarak sıralayınız.
    String QUESTION_7 = "SELECT * FROM ogrenci WHERE sinif = '10A' ORDER BY ogrno DESC;";
    @Query(value = QUESTION_7, nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();

    // 8) Öğrenciler tablosundaki en genç öğrenciyi listeleyiniz.
    String QUESTION_8 = "SELECT * FROM ogrenci ORDER BY dtarih DESC LIMIT 1;";
    @Query(value = QUESTION_8, nativeQuery = true)
    Ogrenci findYoungestStudent();

    // 9) Öğrenciler tablosundaki en yaşlı öğrenciyi listeleyiniz.
    String QUESTION_9 = "SELECT * FROM ogrenci ORDER BY dtarih ASC LIMIT 1;";
    @Query(value = QUESTION_9, nativeQuery = true)
    Ogrenci findElderStudent();

    // 10) İkinci harfi E olan öğrencileri listeleyiniz.
    String QUESTION_10 = "SELECT * FROM ogrenci WHERE ad LIKE '_e%';";
    @Query(value = QUESTION_10, nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();
}
