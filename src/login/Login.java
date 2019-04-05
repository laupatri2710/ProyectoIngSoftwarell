package login;

public class Login {

    public static String login(String numDoc, String clave) {

        if (numDoc.equals("admin") && clave.equals("admin")) {
            return "OK";
        }
        else return "MAL";
    }
}
