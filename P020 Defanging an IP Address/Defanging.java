public class Defanging {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");

    }
}
