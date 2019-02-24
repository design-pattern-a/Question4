
package newpharmacy;

import javax.swing.JTable;


public class RealData implements LoadRecord {
    
    private String query;
    private JTable table;
    
    public RealData(JTable table, String query){
        this.query = query;
        this.table = table;
        fromDatabase(table, query);
    }

    @Override
    public void fetchData(JTable table, String query) {
        fromDatabase(table, query);
    }
    
    public void fromDatabase(JTable table, String query){
        DBConnection connect = new DBConnection();
        connect.fillRecordsTable(table, query);
//        System.out.println("loaded from db");
    }
    
}
