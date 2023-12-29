package com.example.kiemtraand.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QLSanPham", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(MaSP INTEGER PRIMARY KEY AUTOINCREMENT, " + "TenSP TEXT, GiaTien REAL, Image TEXT)";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES(1, 'Muffin xúc xích', '20000', 'https://mcdonalds.vn/uploads/2018/food/muffin/sausage_mcmuffin_deluxe_0.png')," +
                "(2, 'Bugger', '50000', 'https://mcdonalds.vn/uploads/2018/food/burgers/cheesedlx_bb.png')," +
                "(3, 'Sữa chua KIWI ', '60000', 'https://mcdonalds.vn/uploads/2018/food-categories/yogurt-kiwi.png')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
}
