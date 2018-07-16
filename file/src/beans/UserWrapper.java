package beans;

import java.io.Serializable;

public class UserWrapper implements Serializable {

    private User[] competitors = null;

    public User[] getCompetitors() {
        return competitors;
    }

    public void setCompetitors(User[] competitors) {
        this.competitors = competitors;
    }
}
