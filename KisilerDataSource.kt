package com.example.ccontectssmvvm.data.datasource

import android.util.Log
import com.example.ccontectssmvvm.data.entity.Kisiler
import com.example.ccontectssmvvm.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kdao :KisilerDao) {

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){

            return@withContext kdao.kisileriYukle().kisiler

        }


    suspend fun ara(aramaKelimesi:String) :List<Kisiler> =
        withContext(Dispatchers.IO){

            return@withContext kdao.ara(aramaKelimesi).kisiler
        }



    suspend fun kaydet(kisi_ad:String,kisi_tel:String){
        kdao.kaydet(kisi_ad, kisi_tel)
        Log.e("Kişi Kaydet","$kisi_ad - $kisi_tel")
    }


    //  2.yöntem
    // suspend fun kaydet(kisi_ad:String,kisi_tel:String) = kdao.kaydet(kisi_ad, kisi_tel)


    suspend fun buttonGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        kdao.güncelle(kisi_id, kisi_ad, kisi_tel)
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
    }

    suspend fun sil(kisi_id:Int){
        kdao.sil(kisi_id)
        Log.e("Kişi Sil",kisi_id.toString())
    }



}