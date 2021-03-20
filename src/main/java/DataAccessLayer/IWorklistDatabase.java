package DataAccessLayer;

import BusinessLogicLayer.User.User;
import BusinessLogicLayer.WorklistRequest.WorklistRequest;

public interface IWorklistDatabase {
    boolean addWorkListRequest(WorklistRequest worklistRequest, User user);
}
