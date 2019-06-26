package base.pkj;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBH extends SQLiteOpenHelper {
	
    private static final String DATABASE_NAME = "/mnt/sdcard/pkj.db";    // Database Name
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "nyanyian";   // Table Name
    private static final String ID="n_id";     // Column I (Primary Key)
    private static final String LIRIK = "lirik";    //Column II
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
            " ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+LIRIK+" TEXT);";
    
    public DBH(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    
    public Cursor getLirik(int i) {
    	SQLiteDatabase db = getReadableDatabase();
    	Cursor cursor = db.rawQuery("SELECT * FROM nyanyian WHERE n_id = " + i, null);
    	return cursor; 
    }
}
