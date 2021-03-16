package BusinessLogicLayer;

import java.util.HashMap;
import java.util.Map;

public enum CustomerTable {
    FIRST_NAME(1, "First Name", "first_name"),
    LAST_NAME(2,"Last Name", "last_name");

    int sequenceNumber;
    String columnDisplayName;
    String columnName;
    public static Map<Integer, CustomerTable> getColumnsInfo= new HashMap();

    CustomerTable(int sequenceNumber, String columnDisplayName, String columnName) {
        this.sequenceNumber = sequenceNumber;
        this.columnDisplayName = columnDisplayName;
        this.columnName = columnName;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getColumnDisplayName() {
        return columnDisplayName;
    }

    public void setColumnDisplayName(String columnDisplayName) {
        this.columnDisplayName = columnDisplayName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    static {
        for(CustomerTable columnInfo: CustomerTable.values()) {
            getColumnsInfo.put(columnInfo.getSequenceNumber(),columnInfo);
        }
    }
}
