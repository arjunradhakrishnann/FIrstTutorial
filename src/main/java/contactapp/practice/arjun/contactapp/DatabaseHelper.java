package contactapp.practice.arjun.contactapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.Intents.Insert.COMPANY;
import static android.provider.Telephony.Carriers.NAME;

/**
 * Created by CTPL-DM05 on 09-02-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE="one.db";
    public static String TABLE="TODAYDUMMIESS";
    public static String FNAME="fname";
    public static String LNAME="lname";
    public static String EMAIL="email";
    public static String PHONE="phone";
    String br;

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  br= "CREATE TABLE mytable(name TEXT,company TEXT,city TEXT,country TEXT);";
        br = "CREATE TABLE "+TABLE+"("+FNAME+ " Text, "+LNAME+ " Text, "+EMAIL+ " Text, "+PHONE+ " Integer);";
        db.execSQL(br);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE+" ;");
    }








    public void insertdata(String fname,String lname ,String email,Integer phone){
        System.out.print("Hello "+br);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();


        contentValues.put(FNAME, fname);
        contentValues.put(LNAME, lname);
        contentValues.put(EMAIL,email);
        contentValues.put(PHONE,phone);
        db.insert(TABLE,null,contentValues);


    }

    public List<DataModel> getdata(){
        // DataModel dataModel = new DataModel();
        List<DataModel> data=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE+" ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()) {
            dataModel= new DataModel();
            String fname = cursor.getString(cursor.getColumnIndexOrThrow("fname"));
            String lname = cursor.getString(cursor.getColumnIndexOrThrow("lname"));
            String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            Integer phone=cursor.getInt(cursor.getColumnIndexOrThrow("phone"));
            dataModel.setFname(fname);
            dataModel.setLname(lname);
            dataModel.setEmail(email);
            dataModel.setPhone(phone);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }

        for (DataModel mo:data ) {

            Log.i("Hellomo",""+mo.getEmail());
        }

        //

        return data;
    }



}
