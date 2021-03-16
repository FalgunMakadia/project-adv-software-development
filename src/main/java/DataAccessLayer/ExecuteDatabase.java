package DataAccessLayer;

import java.sql.ResultSet;

public class ExecuteDatabase {

    public ResultSet executeSelect(IDatabaseSelect database){
        ResultSet rs =  null;
        rs = database.operateSelect();

        return rs;
    }

    public Boolean execute(IDatabaseUpdate database){
        int affectedRow;
        affectedRow = database.operateUpdate();
        if(affectedRow > 0)
            return true;
        else
            return false;

    }

}
