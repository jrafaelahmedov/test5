package bean;

public class MessageConstant {
    public static final String menuDescriptionAfterLoginAdmin =
            "Please choose menu:\n" +
                    "1.Show users\n" +
                    "2.Show active users\n" +
                    "3.Show inactive users\n" +
                    "4.Approve user\n"+
                    "9.Set non accessible files or folders for user\n" +
                    "10.Set files or folders";

    public static final String menuDescriptionAfterLoginUser =
            "Please choose menu:\n" +
                    "5.Show myself\n" +
                    "6.Enter file or folder\n";

    public static final String menuDescriptionBeforeLogin =
            "Please choose menu:\n" +
                    "7.Register\n" +
                    "8.Login\n";

    public static final String hasNotAccess ="You don't have an access to this path";
    public static final String allInActiveUsers ="All inactive users";

    public static final String whichUserToApprove="Which user you want to approve?";
}
