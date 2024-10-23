package com.workintech.sqldmljoins.repository;

import com.workintech.sqldmljoins.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KitapRepository extends JpaRepository<Kitap, Long> {
//    SELECT  * FROM kitap AS k,tur AS t
//    WHERE k.turno = t.turno
//    AND t.ad='Hikaye' OR t.ad='Dram';

    //Dram ve Hikaye türündeki kitapları listeleyin. JOIN kullanmadan yapın.
    String QUESTION_1 = "SELECT k.kitapno, k.ad as kitapadi, k.puan, k.yazarno, k.turno, t.ad FROM kitap as k\n" +
            "JOIN tur as t ON t.turno= k.turno WHERE t.ad IN ('Dram', 'Hikaye')";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Kitap> findBooks();


    String QUESTION_10 = "SELECT AVG(puan) FROM kitap";
    @Query(value = QUESTION_10, nativeQuery = true)
    Double findAvgPointOfBooks();


}
