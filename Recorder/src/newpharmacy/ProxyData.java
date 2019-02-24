
package newpharmacy;

import javax.swing.JTable;


public class ProxyData implements LoadRecord {
    
    private RealData real;
    private String query;
    private JTable table;
    
    public ProxyData(JTable table, String query){
        this.query = query;
        this.table = table;
    }
    
    @Override
    public void fetchData(JTable table, String query) {
        if(real == null){
            real = new RealData(table, query);
        }
        real.fetchData(table, query);
    }
    
}
